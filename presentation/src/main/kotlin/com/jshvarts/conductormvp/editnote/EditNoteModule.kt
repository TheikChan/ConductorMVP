package com.jshvarts.conductormvp.editnote

import com.jshvarts.conductormvp.di.PerScreen
import com.jshvarts.notedomain.model.NoteValidator
import com.jshvarts.notedomain.repository.NoteRepository
import com.jshvarts.notedomain.usecases.EditNoteUseCase
import com.jshvarts.notedomain.usecases.NoteDetailUseCase
import dagger.Module
import dagger.Provides

@Module
class EditNoteModule {

    @PerScreen
    @Provides
    fun provideNoteDetailUseCase(noteRepository: NoteRepository) = NoteDetailUseCase(noteRepository)

    @PerScreen
    @Provides
    fun provideEditNoteUseCase(noteRepository: NoteRepository, noteValidator: NoteValidator) = EditNoteUseCase(noteRepository, noteValidator)

    @PerScreen
    @Provides
    fun provideView() = EditNoteView()

    @PerScreen
    @Provides
    fun providePresenter(noteDetailUseCase: NoteDetailUseCase, editNoteUseCase: EditNoteUseCase) = EditNotePresenter(noteDetailUseCase, editNoteUseCase)
}