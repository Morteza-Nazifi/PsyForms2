package ir.psyforms.app.di

import android.content.Context

import androidx.room.Room

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import ir.psyforms.app.data.local.PsyFormsDatabase
import ir.psyforms.app.data.local.dao.*

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): PsyFormsDatabase {

        return Room.databaseBuilder(
            context,
            PsyFormsDatabase::class.java,
            "psyforms.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    // ---------- Repository Data ----------

    @Provides
    fun provideDomainDao(
        database: PsyFormsDatabase
    ): DomainDao = database.domainDao()

    @Provides
    fun provideQuestionnaireDao(
        database: PsyFormsDatabase
    ): QuestionnaireDao = database.questionnaireDao()

    @Provides
    fun provideSubscaleDao(
        database: PsyFormsDatabase
    ): SubscaleDao = database.subscaleDao()

    @Provides
    fun provideQuestionDao(
        database: PsyFormsDatabase
    ): QuestionDao = database.questionDao()

    @Provides
    fun provideOptionTemplateDao(
        database: PsyFormsDatabase
    ): OptionTemplateDao = database.optionTemplateDao()

    @Provides
    fun provideOptionTemplateItemDao(
        database: PsyFormsDatabase
    ): OptionTemplateItemDao =
        database.optionTemplateItemDao()

    @Provides
    fun provideScoringRuleDao(
        database: PsyFormsDatabase
    ): ScoringRuleDao =
        database.scoringRuleDao()

    // ---------- User Data ----------

    @Provides
    fun provideSessionDao(
        database: PsyFormsDatabase
    ): SessionDao =
        database.sessionDao()

    @Provides
    fun provideDemographicDao(
        database: PsyFormsDatabase
    ): DemographicDao =
        database.demographicDao()

    @Provides
    fun provideResponseDao(
        database: PsyFormsDatabase
    ): ResponseDao =
        database.responseDao()

    @Provides
    fun provideScoreDao(
        database: PsyFormsDatabase
    ): ScoreDao =
        database.scoreDao()
}
