package com.example.data.local.entity;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ|\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b!\u0010\u001b¨\u00063"},
   d2 = {"Lcom/example/data/local/entity/NoteEntity;", "", "id", "", "userId", "", "title", "content", "categoryId", "reminderTime", "", "linkedDate", "linkedMeetingId", "updatedAt", "deletedAt", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;JLjava/lang/Long;)V", "getId", "()I", "getUserId", "()Ljava/lang/String;", "getTitle", "getContent", "getCategoryId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReminderTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLinkedDate", "getLinkedMeetingId", "getUpdatedAt", "()J", "getDeletedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;JLjava/lang/Long;)Lcom/example/data/local/entity/NoteEntity;", "equals", "", "other", "hashCode", "toString", "app"}
)
@Entity(
   tableName = "notes",
   indices = {@Index({"categoryId"})},
   foreignKeys = {@ForeignKey(
   entity = CategoryEntity.class,
   parentColumns = {"id"},
   childColumns = {"categoryId"},
   onDelete = 3
)}
)
@StabilityInferred(
   parameters = 1
)
public final class NoteEntity {
   @PrimaryKey(
      autoGenerate = true
   )
   private final int id;
   @NotNull
   private final String userId;
   @NotNull
   private final String title;
   @NotNull
   private final String content;
   @Nullable
   private final Integer categoryId;
   @Nullable
   private final Long reminderTime;
   @Nullable
   private final Long linkedDate;
   @Nullable
   private final String linkedMeetingId;
   private final long updatedAt;
   @Nullable
   private final Long deletedAt;
   public static final int $stable;

   public NoteEntity(int id, @NotNull String userId, @NotNull String title, @NotNull String content, @Nullable Integer categoryId, @Nullable Long reminderTime, @Nullable Long linkedDate, @Nullable String linkedMeetingId, long updatedAt, @Nullable Long deletedAt) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      Intrinsics.checkNotNullParameter(title, "title");
      Intrinsics.checkNotNullParameter(content, "content");
      super();
      this.id = id;
      this.userId = userId;
      this.title = title;
      this.content = content;
      this.categoryId = categoryId;
      this.reminderTime = reminderTime;
      this.linkedDate = linkedDate;
      this.linkedMeetingId = linkedMeetingId;
      this.updatedAt = updatedAt;
      this.deletedAt = deletedAt;
   }

   // $FF: synthetic method
   public NoteEntity(int var1, String var2, String var3, String var4, Integer var5, Long var6, Long var7, String var8, long var9, Long var11, int var12, DefaultConstructorMarker var13) {
      if ((var12 & 1) != 0) {
         var1 = 0;
      }

      if ((var12 & 2) != 0) {
         var2 = "";
      }

      if ((var12 & 32) != 0) {
         var6 = null;
      }

      if ((var12 & 64) != 0) {
         var7 = null;
      }

      if ((var12 & 128) != 0) {
         var8 = null;
      }

      if ((var12 & 256) != 0) {
         var9 = System.currentTimeMillis();
      }

      if ((var12 & 512) != 0) {
         var11 = null;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11);
   }

   public final int getId() {
      return this.id;
   }

   @NotNull
   public final String getUserId() {
      return this.userId;
   }

   @NotNull
   public final String getTitle() {
      return this.title;
   }

   @NotNull
   public final String getContent() {
      return this.content;
   }

   @Nullable
   public final Integer getCategoryId() {
      return this.categoryId;
   }

   @Nullable
   public final Long getReminderTime() {
      return this.reminderTime;
   }

   @Nullable
   public final Long getLinkedDate() {
      return this.linkedDate;
   }

   @Nullable
   public final String getLinkedMeetingId() {
      return this.linkedMeetingId;
   }

   public final long getUpdatedAt() {
      return this.updatedAt;
   }

   @Nullable
   public final Long getDeletedAt() {
      return this.deletedAt;
   }

   public final int component1() {
      return this.id;
   }

   @NotNull
   public final String component2() {
      return this.userId;
   }

   @NotNull
   public final String component3() {
      return this.title;
   }

   @NotNull
   public final String component4() {
      return this.content;
   }

   @Nullable
   public final Integer component5() {
      return this.categoryId;
   }

   @Nullable
   public final Long component6() {
      return this.reminderTime;
   }

   @Nullable
   public final Long component7() {
      return this.linkedDate;
   }

   @Nullable
   public final String component8() {
      return this.linkedMeetingId;
   }

   public final long component9() {
      return this.updatedAt;
   }

   @Nullable
   public final Long component10() {
      return this.deletedAt;
   }

   @NotNull
   public final NoteEntity copy(int id, @NotNull String userId, @NotNull String title, @NotNull String content, @Nullable Integer categoryId, @Nullable Long reminderTime, @Nullable Long linkedDate, @Nullable String linkedMeetingId, long updatedAt, @Nullable Long deletedAt) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      Intrinsics.checkNotNullParameter(title, "title");
      Intrinsics.checkNotNullParameter(content, "content");
      return new NoteEntity(id, userId, title, content, categoryId, reminderTime, linkedDate, linkedMeetingId, updatedAt, deletedAt);
   }

   // $FF: synthetic method
   public static NoteEntity copy$default(NoteEntity var0, int var1, String var2, String var3, String var4, Integer var5, Long var6, Long var7, String var8, long var9, Long var11, int var12, Object var13) {
      if ((var12 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var12 & 2) != 0) {
         var2 = var0.userId;
      }

      if ((var12 & 4) != 0) {
         var3 = var0.title;
      }

      if ((var12 & 8) != 0) {
         var4 = var0.content;
      }

      if ((var12 & 16) != 0) {
         var5 = var0.categoryId;
      }

      if ((var12 & 32) != 0) {
         var6 = var0.reminderTime;
      }

      if ((var12 & 64) != 0) {
         var7 = var0.linkedDate;
      }

      if ((var12 & 128) != 0) {
         var8 = var0.linkedMeetingId;
      }

      if ((var12 & 256) != 0) {
         var9 = var0.updatedAt;
      }

      if ((var12 & 512) != 0) {
         var11 = var0.deletedAt;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11);
   }

   @NotNull
   public String toString() {
      return "NoteEntity(id=" + this.id + ", userId=" + this.userId + ", title=" + this.title + ", content=" + this.content + ", categoryId=" + this.categoryId + ", reminderTime=" + this.reminderTime + ", linkedDate=" + this.linkedDate + ", linkedMeetingId=" + this.linkedMeetingId + ", updatedAt=" + this.updatedAt + ", deletedAt=" + this.deletedAt + ")";
   }

   public int hashCode() {
      int result = Integer.hashCode(this.id);
      result = result * 31 + this.userId.hashCode();
      result = result * 31 + this.title.hashCode();
      result = result * 31 + this.content.hashCode();
      result = result * 31 + (this.categoryId == null ? 0 : this.categoryId.hashCode());
      result = result * 31 + (this.reminderTime == null ? 0 : this.reminderTime.hashCode());
      result = result * 31 + (this.linkedDate == null ? 0 : this.linkedDate.hashCode());
      result = result * 31 + (this.linkedMeetingId == null ? 0 : this.linkedMeetingId.hashCode());
      result = result * 31 + Long.hashCode(this.updatedAt);
      result = result * 31 + (this.deletedAt == null ? 0 : this.deletedAt.hashCode());
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof NoteEntity)) {
         return false;
      } else {
         NoteEntity var2 = (NoteEntity)other;
         if (this.id != var2.id) {
            return false;
         } else if (!Intrinsics.areEqual(this.userId, var2.userId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.title, var2.title)) {
            return false;
         } else if (!Intrinsics.areEqual(this.content, var2.content)) {
            return false;
         } else if (!Intrinsics.areEqual(this.categoryId, var2.categoryId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.reminderTime, var2.reminderTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.linkedDate, var2.linkedDate)) {
            return false;
         } else if (!Intrinsics.areEqual(this.linkedMeetingId, var2.linkedMeetingId)) {
            return false;
         } else if (this.updatedAt != var2.updatedAt) {
            return false;
         } else {
            return Intrinsics.areEqual(this.deletedAt, var2.deletedAt);
         }
      }
   }
}
