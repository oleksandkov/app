package com.example.data.local.entity;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
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
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"},
   d2 = {"Lcom/example/data/local/entity/CategoryEntity;", "", "id", "", "name", "", "colorHex", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getColorHex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app"}
)
@Entity(
   tableName = "categories"
)
@StabilityInferred(
   parameters = 1
)
public final class CategoryEntity {
   @PrimaryKey(
      autoGenerate = true
   )
   private final int id;
   @NotNull
   private final String name;
   @NotNull
   private final String colorHex;
   public static final int $stable;

   public CategoryEntity(int id, @NotNull String name, @NotNull String colorHex) {
      Intrinsics.checkNotNullParameter(name, "name");
      Intrinsics.checkNotNullParameter(colorHex, "colorHex");
      super();
      this.id = id;
      this.name = name;
      this.colorHex = colorHex;
   }

   // $FF: synthetic method
   public CategoryEntity(int var1, String var2, String var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 1) != 0) {
         var1 = 0;
      }

      this(var1, var2, var3);
   }

   public final int getId() {
      return this.id;
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   @NotNull
   public final String getColorHex() {
      return this.colorHex;
   }

   public final int component1() {
      return this.id;
   }

   @NotNull
   public final String component2() {
      return this.name;
   }

   @NotNull
   public final String component3() {
      return this.colorHex;
   }

   @NotNull
   public final CategoryEntity copy(int id, @NotNull String name, @NotNull String colorHex) {
      Intrinsics.checkNotNullParameter(name, "name");
      Intrinsics.checkNotNullParameter(colorHex, "colorHex");
      return new CategoryEntity(id, name, colorHex);
   }

   // $FF: synthetic method
   public static CategoryEntity copy$default(CategoryEntity var0, int var1, String var2, String var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.colorHex;
      }

      return var0.copy(var1, var2, var3);
   }

   @NotNull
   public String toString() {
      return "CategoryEntity(id=" + this.id + ", name=" + this.name + ", colorHex=" + this.colorHex + ")";
   }

   public int hashCode() {
      int result = Integer.hashCode(this.id);
      result = result * 31 + this.name.hashCode();
      result = result * 31 + this.colorHex.hashCode();
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof CategoryEntity)) {
         return false;
      } else {
         CategoryEntity var2 = (CategoryEntity)other;
         if (this.id != var2.id) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var2.name)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.colorHex, var2.colorHex);
         }
      }
   }
}
