package com.example.notes;

import android.app.Application;
import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.data.local.AppDatabase;
import com.example.data.local.dao.NoteDao;
import com.example.data.local.entity.NoteEntity;
import com.example.notification.ReminderScheduler;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.SharingStarted.Companion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0002J?\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0013J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006'"},
   d2 = {"Lcom/example/notes/NotesViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "db", "Lcom/example/data/local/AppDatabase;", "noteDao", "Lcom/example/data/local/dao/NoteDao;", "scheduler", "Lcom/example/notification/ReminderScheduler;", "currentUserId", "", "getCurrentUserId", "()Ljava/lang/String;", "allNotes", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/data/local/entity/NoteEntity;", "getAllNotes", "()Lkotlinx/coroutines/flow/StateFlow;", "_notesForToday", "Lkotlinx/coroutines/flow/MutableStateFlow;", "notesForToday", "getNotesForToday", "fetchNotesForToday", "", "addNote", "title", "content", "linkedDate", "", "linkedMeetingId", "reminderTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "updateNote", "note", "deleteNote", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class NotesViewModel extends AndroidViewModel {
   @NotNull
   private final AppDatabase db;
   @NotNull
   private final NoteDao noteDao;
   @NotNull
   private final ReminderScheduler scheduler;
   @NotNull
   private final StateFlow allNotes;
   @NotNull
   private final MutableStateFlow _notesForToday;
   @NotNull
   private final StateFlow notesForToday;
   public static final int $stable = 8;

   public NotesViewModel(@NotNull Application application) {
      Intrinsics.checkNotNullParameter(application, "application");
      super(application);
      this.db = AppDatabase.Companion.getDatabase((Context)application);
      this.noteDao = this.db.noteDao();
      this.scheduler = new ReminderScheduler((Context)application);
      this.allNotes = FlowKt.stateIn(this.noteDao.getAllNotes(this.getCurrentUserId()), ViewModelKt.getViewModelScope((ViewModel)this), Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object)null), CollectionsKt.emptyList());
      this._notesForToday = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
      this.notesForToday = (StateFlow)this._notesForToday;
      this.fetchNotesForToday();
   }

   private final String getCurrentUserId() {
      FirebaseUser var10000 = FirebaseAuth.getInstance().getCurrentUser();
      String var1;
      if (var10000 != null) {
         var1 = var10000.getUid();
         if (var1 != null) {
            return var1;
         }
      }

      var1 = "";
      return var1;
   }

   @NotNull
   public final StateFlow getAllNotes() {
      return this.allNotes;
   }

   @NotNull
   public final StateFlow getNotesForToday() {
      return this.notesForToday;
   }

   private final void fetchNotesForToday() {
      Calendar calendar = Calendar.getInstance();
      calendar.set(11, 0);
      calendar.set(12, 0);
      calendar.set(13, 0);
      calendar.set(14, 0);
      final long startOfDay = calendar.getTimeInMillis();
      calendar.set(11, 23);
      calendar.set(12, 59);
      calendar.set(13, 59);
      final long endOfDay = calendar.getTimeInMillis();
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  Flow var10000 = NotesViewModel.this.noteDao.getNotesForDate(NotesViewModel.this.getCurrentUserId(), startOfDay, endOfDay);
                  FlowCollector var10001 = new FlowCollector() {
                     public final Object emit(List it, Continuation $completion) {
                        NotesViewModel.this._notesForToday.setValue(it);
                        return Unit.INSTANCE;
                     }
                  };
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.collect(var10001, var10002) == var2) {
                     return var2;
                  }
                  break;
               case 1:
                  ResultKt.throwOnFailure($result);
                  break;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            return Unit.INSTANCE;
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   public final void addNote(@NotNull final String title, @NotNull final String content, @Nullable final Long linkedDate, @Nullable final String linkedMeetingId, @Nullable final Long reminderTime) {
      Intrinsics.checkNotNullParameter(title, "title");
      Intrinsics.checkNotNullParameter(content, "content");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         Object L$0;
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Object var10000;
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  String var3 = NotesViewModel.this.getCurrentUserId();
                  NoteEntity note = new NoteEntity(0, var3, title, content, (Integer)null, reminderTime, linkedDate, linkedMeetingId, 0L, (Long)null, 769, (DefaultConstructorMarker)null);
                  var10000 = NotesViewModel.this.noteDao;
                  Continuation var10002 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(note);
                  this.label = 1;
                  var10000 = (NoteDao)var10000.insertNote(note, var10002);
                  if (var10000 == var4) {
                     return var4;
                  }
                  break;
               case 1:
                  NoteEntity note = (NoteEntity)this.L$0;
                  ResultKt.throwOnFailure($result);
                  var10000 = (NoteDao)$result;
                  break;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            int noteId = (int)((Number)var10000).longValue();
            if (reminderTime != null) {
               NotesViewModel.this.scheduler.scheduleReminder(noteId, "note", reminderTime);
            }

            return Unit.INSTANCE;
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   // $FF: synthetic method
   public static void addNote$default(NotesViewModel var0, String var1, String var2, Long var3, String var4, Long var5, int var6, Object var7) {
      if ((var6 & 4) != 0) {
         var3 = null;
      }

      if ((var6 & 8) != 0) {
         var4 = null;
      }

      if ((var6 & 16) != 0) {
         var5 = null;
      }

      var0.addNote(var1, var2, var3, var4, var5);
   }

   public final void updateNote(@NotNull final NoteEntity note) {
      Intrinsics.checkNotNullParameter(note, "note");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  NoteDao var10000 = NotesViewModel.this.noteDao;
                  NoteEntity var10001 = note;
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.updateNote(var10001, var10002) == var2) {
                     return var2;
                  }
                  break;
               case 1:
                  ResultKt.throwOnFailure($result);
                  break;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            if (note.getReminderTime() != null) {
               NotesViewModel.this.scheduler.scheduleReminder(note.getId(), "note", note.getReminderTime());
            } else {
               NotesViewModel.this.scheduler.cancelReminder(note.getId(), "note");
            }

            return Unit.INSTANCE;
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   public final void deleteNote(@NotNull final NoteEntity note) {
      Intrinsics.checkNotNullParameter(note, "note");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  NoteDao var10000 = NotesViewModel.this.noteDao;
                  int var10001 = note.getId();
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.deleteNoteById(var10001, var10002) == var2) {
                     return var2;
                  }
                  break;
               case 1:
                  ResultKt.throwOnFailure($result);
                  break;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            NotesViewModel.this.scheduler.cancelReminder(note.getId(), "note");
            return Unit.INSTANCE;
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }
}
