package com.example.auth;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"},
   d2 = {"Lcom/example/auth/AuthState;", "", "<init>", "()V", "Idle", "Loading", "Success", "Error", "Lcom/example/auth/AuthState$Error;", "Lcom/example/auth/AuthState$Idle;", "Lcom/example/auth/AuthState$Loading;", "Lcom/example/auth/AuthState$Success;", "app"}
)
@StabilityInferred(
   parameters = 1
)
public abstract class AuthState {
   public static final int $stable;

   private AuthState() {
   }

   // $FF: synthetic method
   public AuthState(DefaultConstructorMarker $constructor_marker) {
      this();
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/example/auth/AuthState$Idle;", "Lcom/example/auth/AuthState;", "<init>", "()V", "app"}
   )
   @StabilityInferred(
      parameters = 1
   )
   public static final class Idle extends AuthState {
      @NotNull
      public static final Idle INSTANCE = new Idle();
      public static final int $stable;

      private Idle() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/example/auth/AuthState$Loading;", "Lcom/example/auth/AuthState;", "<init>", "()V", "app"}
   )
   @StabilityInferred(
      parameters = 1
   )
   public static final class Loading extends AuthState {
      @NotNull
      public static final Loading INSTANCE = new Loading();
      public static final int $stable;

      private Loading() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"},
      d2 = {"Lcom/example/auth/AuthState$Success;", "Lcom/example/auth/AuthState;", "userEmail", "", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserEmail", "()Ljava/lang/String;", "getDisplayName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app"}
   )
   @StabilityInferred(
      parameters = 1
   )
   public static final class Success extends AuthState {
      @NotNull
      private final String userEmail;
      @NotNull
      private final String displayName;
      public static final int $stable;

      public Success(@NotNull String userEmail, @NotNull String displayName) {
         Intrinsics.checkNotNullParameter(userEmail, "userEmail");
         Intrinsics.checkNotNullParameter(displayName, "displayName");
         super((DefaultConstructorMarker)null);
         this.userEmail = userEmail;
         this.displayName = displayName;
      }

      @NotNull
      public final String getUserEmail() {
         return this.userEmail;
      }

      @NotNull
      public final String getDisplayName() {
         return this.displayName;
      }

      @NotNull
      public final String component1() {
         return this.userEmail;
      }

      @NotNull
      public final String component2() {
         return this.displayName;
      }

      @NotNull
      public final Success copy(@NotNull String userEmail, @NotNull String displayName) {
         Intrinsics.checkNotNullParameter(userEmail, "userEmail");
         Intrinsics.checkNotNullParameter(displayName, "displayName");
         return new Success(userEmail, displayName);
      }

      // $FF: synthetic method
      public static Success copy$default(Success var0, String var1, String var2, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = var0.userEmail;
         }

         if ((var3 & 2) != 0) {
            var2 = var0.displayName;
         }

         return var0.copy(var1, var2);
      }

      @NotNull
      public String toString() {
         return "Success(userEmail=" + this.userEmail + ", displayName=" + this.displayName + ")";
      }

      public int hashCode() {
         int result = this.userEmail.hashCode();
         result = result * 31 + this.displayName.hashCode();
         return result;
      }

      public boolean equals(@Nullable Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof Success)) {
            return false;
         } else {
            Success var2 = (Success)other;
            if (!Intrinsics.areEqual(this.userEmail, var2.userEmail)) {
               return false;
            } else {
               return Intrinsics.areEqual(this.displayName, var2.displayName);
            }
         }
      }
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/example/auth/AuthState$Error;", "Lcom/example/auth/AuthState;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app"}
   )
   @StabilityInferred(
      parameters = 1
   )
   public static final class Error extends AuthState {
      @NotNull
      private final String message;
      public static final int $stable;

      public Error(@NotNull String message) {
         Intrinsics.checkNotNullParameter(message, "message");
         super((DefaultConstructorMarker)null);
         this.message = message;
      }

      @NotNull
      public final String getMessage() {
         return this.message;
      }

      @NotNull
      public final String component1() {
         return this.message;
      }

      @NotNull
      public final Error copy(@NotNull String message) {
         Intrinsics.checkNotNullParameter(message, "message");
         return new Error(message);
      }

      // $FF: synthetic method
      public static Error copy$default(Error var0, String var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.message;
         }

         return var0.copy(var1);
      }

      @NotNull
      public String toString() {
         return "Error(message=" + this.message + ")";
      }

      public int hashCode() {
         return this.message.hashCode();
      }

      public boolean equals(@Nullable Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof Error)) {
            return false;
         } else {
            Error var2 = (Error)other;
            return Intrinsics.areEqual(this.message, var2.message);
         }
      }
   }
}
