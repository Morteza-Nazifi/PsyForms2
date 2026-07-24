package ir.psyforms.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

import ir.psyforms.app.data.local.dao.DomainDao
import ir.psyforms.app.data.local.dao.QuestionnaireDao
import ir.psyforms.app.data.local.dao.SubscaleDao
import ir.psyforms.app.data.local.dao.QuestionDao
import ir.psyforms.app.data.local.dao.OptionTemplateDao
import ir.psyforms.app.data.local.dao.OptionTemplateItemDao
import ir.psyforms.app.data.local.dao.ScoringRuleDao
import ir.psyforms.app.data.local.dao.SessionDao
import ir.psyforms.app.data.local.dao.DemographicDao
import ir.psyforms.app.data.local.dao.ResponseDao
import ir.psyforms.app.data.local.dao.ScoreDao

import ir.psyforms.app.data.local.entity.DomainEntity
import ir.psyforms.app.data.local.entity.QuestionnaireEntity
import ir.psyforms.app.data.local.entity.SubscaleEntity
import ir.psyforms.app.data.local.entity.QuestionEntity
import ir.psyforms.app.data.local.entity.OptionTemplateEntity
import ir.psyforms.app.data.local.entity.OptionTemplateItemEntity
import ir.psyforms.app.data.local.entity.ScoringRuleEntity
import ir.psyforms.app.data.local.entity.SessionEntity
import ir.psyforms.app.data.local.entity.DemographicEntity
import ir.psyforms.app.data.local.entity.ResponseEntity
import ir.psyforms.app.data.local.entity.ScoreEntity

@Database(
    entities = [
        DomainEntity::class,
        QuestionnaireEntity::class,
        SubscaleEntity::class,
        QuestionEntity::class,
        OptionTemplateEntity::class,
        OptionTemplateItemEntity::class,
        ScoringRuleEntity::class,

        SessionEntity::class,
        DemographicEntity::class,
        ResponseEntity::class,
        ScoreEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class PsyFormsDatabase : RoomDatabase() {

    // Repository Data

    abstract fun domainDao(): DomainDao

    abstract fun questionnaireDao(): QuestionnaireDao

    abstract fun subscaleDao(): SubscaleDao

    abstract fun questionDao(): QuestionDao

    abstract fun optionTemplateDao(): OptionTemplateDao

    abstract fun optionTemplateItemDao(): OptionTemplateItemDao

    abstract fun scoringRuleDao(): ScoringRuleDao

    // User Data

    abstract fun sessionDao(): SessionDao

    abstract fun demographicDao(): DemographicDao

    abstract fun responseDao(): ResponseDao

    abstract fun scoreDao(): ScoreDao
}
