# PsyForms

# Database Design

**Version:** 1.0

**Status:** Approved

---

# 1. مقدمه

این سند طراحی کامل پایگاه داده داخلی PsyForms را مشخص می‌کند.

پایگاه داده بر پایه **Room (SQLite)** پیاده‌سازی می‌شود.

اهداف اصلی طراحی عبارت‌اند از:

- سادگی
- قابلیت توسعه
- استقلال داده‌ها
- جلوگیری از افزونگی
- کارایی بالا
- نگهداری آسان

---

# 2. اصول طراحی

در طراحی پایگاه داده اصول زیر رعایت شده است.

## 2.1 استقلال ساختار و داده

داده‌های پروژه به دو گروه تقسیم می‌شوند.

### الف) داده‌های ساختاری

این داده‌ها از Repository دریافت می‌شوند.

شامل:

- Domain
- Questionnaire
- Subscale
- Question
- OptionTemplate
- ScoringRule

این داده‌ها توسط Developer ایجاد می‌شوند.

---

### ب) داده‌های کاربران

این داده‌ها فقط داخل دستگاه ذخیره می‌شوند.

شامل:

- Session
- Demographic
- Response
- Draft
- Score

هیچ‌یک از این داده‌ها وارد Repository نخواهند شد.

---

# 3. معماری پایگاه داده

پایگاه داده از دو بخش مستقل تشکیل می‌شود.

```

Repository Data

```
Domain
Questionnaire
Subscale
Question
OptionTemplate
ScoringRule

↓

User Data

Session
Demographic
Response
Score

```

به این ترتیب، انتشار پرسشنامه‌ها هیچ تأثیری بر پاسخ‌های کاربران نخواهد داشت.

---

# 4. ER Diagram

ساختار ارتباط موجودیت‌ها به صورت زیر است.

```

Domain
│
└────────────┐
↓
Questionnaire
│
└────────────┐
↓
Subscale
│
└────────────┐
↓
Question
│
├─────────────► OptionTemplate
│
└─────────────► ScoringRule

Session
│
├────────────► Demographic
│
├────────────► Response
│
└────────────► Score

```

---

# 5. لیست Entity ها

پایگاه داده شامل موجودیت‌های زیر است.

## Repository Entities

- DomainEntity
- QuestionnaireEntity
- SubscaleEntity
- QuestionEntity
- OptionTemplateEntity
- OptionTemplateItemEntity
- ScoringRuleEntity

---

## User Entities

- SessionEntity
- DemographicEntity
- ResponseEntity
- ScoreEntity

---

# 6. طراحی کلیدها

تمام Entity ها دارای کلید اصلی از نوع Long خواهند بود.

```

id : Long

```

تمام Foreign Key ها نیز از نوع Long خواهند بود.

از UUID استفاده نخواهد شد.

---

# 7. قواعد نام‌گذاری

نام جدول‌ها به صورت مفرد خواهد بود.

نمونه:

```

DomainEntity

QuestionnaireEntity

QuestionEntity

```

نام ستون‌ها با camelCase نوشته می‌شوند.

نمونه:

```

questionnaireId

subscaleId

displayOrder

hasTotalScore

```

---

# 8. ترتیب نمایش

هیچ داده‌ای بر اساس شناسه مرتب نمی‌شود.

برای تمام اجزای ساختاری یک ستون مستقل وجود دارد.

```

displayOrder

```

نمایش حیطه‌ها، پرسشنامه‌ها، خرده‌مقیاس‌ها و سؤال‌ها فقط بر اساس این ستون انجام می‌شود.

---

# پایان بخش اول
# 9. DomainEntity

این موجودیت بالاترین سطح سازمان‌دهی پرسشنامه‌ها را نگهداری می‌کند.

هر Domain می‌تواند شامل چندین Questionnaire باشد.

## جدول

| ستون | نوع | توضیح |
|------|------|-------|
| id | Long | کلید اصلی |
| name | String | نام حیطه |
| displayOrder | Int | ترتیب نمایش |
| isActive | Boolean | فعال یا غیرفعال بودن |

---

## ارتباط‌ها

```
Domain

1

↓

∞

Questionnaire
```

---

## محدودیت‌ها

- نام حیطه نباید خالی باشد.
- displayOrder باید یکتا باشد.
- حذف Domain باعث حذف تمام Questionnaireهای آن خواهد شد.

---

# 10. QuestionnaireEntity

این موجودیت اطلاعات اصلی هر پرسشنامه را نگهداری می‌کند.

## جدول

| ستون | نوع | توضیح |
|------|------|-------|
| id | Long | کلید اصلی |
| domainId | Long | شناسه حیطه |
| name | String | نام پرسشنامه |
| description | String | توضیح پرسشنامه |
| displayOrder | Int | ترتیب نمایش |
| hasTotalScore | Boolean | داشتن نمره کل |
| isActive | Boolean | وضعیت فعال |

---

## ارتباط‌ها

```
Questionnaire

1

↓

∞

Subscale
```

---

## Foreign Key

```
domainId

↓

Domain.id
```

---

## محدودیت‌ها

- نام نباید خالی باشد.
- هر پرسشنامه باید دقیقاً متعلق به یک Domain باشد.
- حذف Questionnaire باعث حذف Subscaleهای آن خواهد شد.

---

# 11. SubscaleEntity

هر پرسشنامه شامل یک یا چند خرده‌مقیاس است.

## جدول

| ستون | نوع | توضیح |
|------|------|-------|
| id | Long | کلید اصلی |
| questionnaireId | Long | شناسه پرسشنامه |
| name | String | نام خرده‌مقیاس |
| description | String | توضیح |
| displayOrder | Int | ترتیب نمایش |

---

## ارتباط‌ها

```
Subscale

1

↓

∞

Question
```

---

## Foreign Key

```
questionnaireId

↓

Questionnaire.id
```

---

## محدودیت‌ها

- نام نباید خالی باشد.
- حذف Subscale باعث حذف تمام Questionهای آن خواهد شد.

---

# 12. QuestionEntity

این موجودیت تمام سؤال‌های سیستم را نگهداری می‌کند.

## جدول

| ستون | نوع | توضیح |
|------|------|-------|
| id | Long | کلید اصلی |
| subscaleId | Long | شناسه خرده‌مقیاس |
| optionTemplateId | Long? | قالب گزینه‌ها |
| questionType | Int | نوع سؤال |
| title | String | متن سؤال |
| displayOrder | Int | ترتیب نمایش |

---

## انواع سؤال

```
0 = Text

1 = Number

2 = Multiple Choice
```

---

## ارتباط‌ها

```
Question

∞

↓

1

Subscale
```

```
Question

∞

↓

1

OptionTemplate (اختیاری)
```

---

## قواعد

### سؤال متنی

```
optionTemplateId = null
```

---

### سؤال عددی

```
optionTemplateId = null
```

---

### سؤال چندگزینه‌ای

```
optionTemplateId

≠ null
```

---

## محدودیت‌ها

- متن سؤال نباید خالی باشد.
- displayOrder در هر Subscale یکتا است.
- هر سؤال فقط متعلق به یک Subscale است.

-دوم
# 13. جمع‌بندی روابط

```
Domain

↓

Questionnaire

↓

Subscale

↓

Question
```

در این بخش چهار موجودیت اصلی ساختار پرسشنامه تعریف شدند.

در بخش بعدی موجودیت‌های زیر طراحی خواهند شد:

- OptionTemplateEntity
- OptionTemplateItemEntity
- ScoringRuleEntity
- SessionEntity
- DemographicEntity
- ResponseEntity
- ScoreEntity

# پایان بخش دوم
# 14. OptionTemplateEntity

قالب گزینه‌ها مجموعه‌ای از گزینه‌های قابل استفاده مجدد برای سؤال‌های چندگزینه‌ای است.

هدف از این موجودیت جلوگیری از ایجاد قالب‌های تکراری است.

---

## جدول

| ستون | نوع | توضیح |
|------|------|-------|
| id | Long | کلید اصلی |
| optionCount | Int | تعداد گزینه‌ها |

---

## ارتباط‌ها

```
OptionTemplate

1

↓

∞

OptionTemplateItem
```

همچنین:

```
OptionTemplate

1

↓

∞

Question
```

---

## محدودیت‌ها

- حداقل دو گزینه باید وجود داشته باشد.
- قالب‌های تکراری ایجاد نمی‌شوند.
- تشخیص تکراری بودن بر اساس گزینه‌ها و امتیازها انجام می‌شود.

---

# 15. OptionTemplateItemEntity

این جدول گزینه‌های هر قالب را نگهداری می‌کند.

---

## جدول

| ستون | نوع | توضیح |
|------|------|-------|
| id | Long | کلید اصلی |
| templateId | Long | شناسه قالب |
| displayOrder | Int | ترتیب گزینه |
| title | String | متن گزینه |
| score | Double | امتیاز گزینه |

---

## ارتباط

```
OptionTemplate

1

↓

∞

OptionTemplateItem
```

---

## محدودیت‌ها

- displayOrder داخل هر Template یکتا است.
- متن گزینه نباید خالی باشد.

---

## نمونه

```
OptionTemplate

id=5
```

↓

| ترتیب | متن | امتیاز |
|--------|------|---------|
|1|هرگز|0|
|2|گاهی|1|
|3|اغلب|2|
|4|همیشه|3|

---

# 16. ScoringRuleEntity

قوانین نمره‌گذاری هر خرده‌مقیاس در این جدول نگهداری می‌شود.

---

## جدول

| ستون | نوع | توضیح |
|------|------|-------|
| id | Long | کلید اصلی |
| subscaleId | Long | شناسه خرده‌مقیاس |
| questionId | Long | شناسه سؤال |
| isReverse | Boolean | نمره معکوس |

---

## ارتباط

```
Subscale

1

↓

∞

ScoringRule
```

---

## توضیح

برای سؤال‌های معمولی:

```
isReverse=false
```

برای سؤال‌های معکوس:

```
isReverse=true
```

به این ترتیب نیازی به نگهداری فرمول‌های پیچیده در نسخه فعلی وجود ندارد.

---

# 17. SessionEntity

هر بار که کاربر پاسخ‌دهی را آغاز می‌کند، یک Session ایجاد می‌شود.

Session تمام پرسشنامه‌های تکمیل‌شده در یک نوبت را در بر می‌گیرد.

---

## جدول

| ستون | نوع | توضیح |
|------|------|-------|
| id | Long | کلید اصلی |
| startDateTime | Long | زمان شروع |
| finishDateTime | Long? | زمان پایان |
| status | Int | وضعیت Session |

---

## وضعیت‌ها

```
0 = Draft

1 = Completed
```

---

## ارتباط

```
Session

1

↓

1

Demographic
```

```
Session

1

↓

∞

Response
```

```
Session

1

↓

∞

Score
```

---

## قواعد

تا زمانی که آخرین پرسشنامه ثبت نهایی نشده باشد:

```
status = Draft
```

پس از پایان:

```
status = Completed
```

---

# 18. DemographicEntity

اطلاعات جمعیت‌شناختی هر Session در این جدول ذخیره می‌شود.

---

## جدول

| ستون | نوع | توضیح |
|------|------|-------|
| sessionId | Long | کلید اصلی و خارجی |
| gender | Int | جنسیت |
| age | Int | سن |
| educationLevel | Int | مقطع تحصیلی |
| fatherEducation | Int | تحصیلات پدر |
| motherEducation | Int | تحصیلات مادر |

---

## ارتباط

```
Session

1

↓

1

Demographic
```

---

## دلیل طراحی

اطلاعات جمعیت‌شناختی فقط یک بار در هر Session ذخیره می‌شوند و برای تمام پرسشنامه‌های همان Session استفاده خواهند شد.

---

# پایان بخش سوم
