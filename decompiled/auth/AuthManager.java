package com.example.auth;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.tasks.TasksKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0086@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"},
   d2 = {"Lcom/example/auth/AuthManager;", "", "context", "Landroid/content/Context;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "<init>", "(Landroid/content/Context;Lcom/google/firebase/auth/FirebaseAuth;)V", "serverClientId", "", "googleSignInOptions", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "getGoogleSignInOptions", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "googleSignInOptions$delegate", "Lkotlin/Lazy;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "googleSignInClient$delegate", "handleGoogleSignInResult", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCalendarAccessToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class AuthManager {
   @NotNull
   private final Context context;
   @NotNull
   private final FirebaseAuth auth;
   @NotNull
   private final String serverClientId;
   @NotNull
   private final Lazy googleSignInOptions$delegate;
   @NotNull
   private final Lazy googleSignInClient$delegate;
   public static final int $stable = 8;

   public AuthManager(@NotNull Context context, @NotNull FirebaseAuth auth) {
      Intrinsics.checkNotNullParameter(context, "context");
      Intrinsics.checkNotNullParameter(auth, "auth");
      super();
      this.context = context;
      this.auth = auth;
      this.serverClientId = "948511050671-hapsdb912mfm3i2k8prnm8qqt1b4dkqu.apps.googleusercontent.com";
      this.googleSignInOptions$delegate = LazyKt.lazy(AuthManager::googleSignInOptions_delegate$lambda$0);
      this.googleSignInClient$delegate = LazyKt.lazy(AuthManager::googleSignInClient_delegate$lambda$1);
   }

   // $FF: synthetic method
   public AuthManager(Context var1, FirebaseAuth var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         FirebaseAuth var10000 = FirebaseAuth.getInstance();
         Intrinsics.checkNotNullExpressionValue(var10000, "getInstance(...)");
         var2 = var10000;
      }

      this(var1, var2);
   }

   private final GoogleSignInOptions getGoogleSignInOptions() {
      Lazy var1 = this.googleSignInOptions$delegate;
      return (GoogleSignInOptions)var1.getValue();
   }

   @NotNull
   public final GoogleSignInClient getGoogleSignInClient() {
      Lazy var1 = this.googleSignInClient$delegate;
      return (GoogleSignInClient)var1.getValue();
   }

   @Nullable
   public final Object handleGoogleSignInResult(@Nullable Intent intent, @NotNull Continuation $completion) {
      Continuation $continuation;
      label80: {
         if ($completion instanceof <undefinedtype>) {
            $continuation = (<undefinedtype>)$completion;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
               $continuation.label -= Integer.MIN_VALUE;
               break label80;
            }
         }

         $continuation = new ContinuationImpl($completion) {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            // $FF: synthetic field
            Object result;
            int label;

            @Nullable
            public final Object invokeSuspend(@NotNull Object $result) {
               this.result = $result;
               this.label |= Integer.MIN_VALUE;
               return AuthManager.this.handleGoogleSignInResult((Intent)null, (Continuation)this);
            }
         };
      }

      boolean var18;
      Exception var10000;
      label73: {
         label84: {
            Object $result = $continuation.result;
            Object var10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Task task;
            Object var24;
            switch ($continuation.label) {
               case 0:
                  ResultKt.throwOnFailure($result);

                  try {
                     Task var25 = GoogleSignIn.getSignedInAccountFromIntent(intent);
                     Intrinsics.checkNotNullExpressionValue(var25, "getSignedInAccountFromIntent(...)");
                     task = var25;
                     $continuation.L$0 = SpillingKt.nullOutSpilledVariable(intent);
                     $continuation.L$1 = SpillingKt.nullOutSpilledVariable(task);
                     $continuation.label = 1;
                     var24 = TasksKt.await(task, $continuation);
                  } catch (Exception var12) {
                     var10000 = var12;
                     boolean var30 = false;
                     break label73;
                  }

                  if (var24 == var10) {
                     return var10;
                  }
                  break;
               case 1:
                  task = (Task)$continuation.L$1;
                  intent = (Intent)$continuation.L$0;

                  try {
                     ResultKt.throwOnFailure($result);
                     var24 = $result;
                     break;
                  } catch (Exception var13) {
                     var10000 = var13;
                     boolean var29 = false;
                     break label73;
                  }
               case 2:
                  AuthCredential credential = (AuthCredential)$continuation.L$4;
                  String idToken = (String)$continuation.L$3;
                  GoogleSignInAccount account = (GoogleSignInAccount)$continuation.L$2;
                  task = (Task)$continuation.L$1;
                  intent = (Intent)$continuation.L$0;

                  try {
                     ResultKt.throwOnFailure($result);
                     var23 = $result;
                     break label84;
                  } catch (Exception var14) {
                     var10000 = var14;
                     boolean var10001 = false;
                     break label73;
                  }
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            try {
               GoogleSignInAccount account = (GoogleSignInAccount)var24;
               String var26 = account.getIdToken();
               if (var26 == null) {
                  return Boxing.boxBoolean(false);
               }

               String idToken = var26;
               AuthCredential var27 = GoogleAuthProvider.getCredential(idToken, (String)null);
               Intrinsics.checkNotNullExpressionValue(var27, "getCredential(...)");
               AuthCredential credential = var27;
               Task var28 = this.auth.signInWithCredential(credential);
               Intrinsics.checkNotNullExpressionValue(var28, "signInWithCredential(...)");
               $continuation.L$0 = SpillingKt.nullOutSpilledVariable(intent);
               $continuation.L$1 = SpillingKt.nullOutSpilledVariable(task);
               $continuation.L$2 = SpillingKt.nullOutSpilledVariable(account);
               $continuation.L$3 = SpillingKt.nullOutSpilledVariable(idToken);
               $continuation.L$4 = SpillingKt.nullOutSpilledVariable(credential);
               $continuation.label = 2;
               var23 = TasksKt.await(var28, $continuation);
            } catch (Exception var15) {
               var10000 = var15;
               boolean var31 = false;
               break label73;
            }

            if (var23 == var10) {
               return var10;
            }
         }

         try {
            AuthResult authResult = (AuthResult)var23;
            var18 = authResult.getUser() != null;
            return Boxing.boxBoolean(var18);
         } catch (Exception var11) {
            var10000 = var11;
            boolean var32 = false;
         }
      }

      Exception e = var10000;
      e.printStackTrace();
      var18 = false;
      return Boxing.boxBoolean(var18);
   }

   @Nullable
   public final Object getCalendarAccessToken(@NotNull Continuation $completion) {
      return BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);

                  String account;
                  try {
                     GoogleSignInAccount var10000 = GoogleSignIn.getLastSignedInAccount(AuthManager.this.context);
                     if (var10000 == null) {
                        return null;
                     }

                     GoogleSignInAccount account = var10000;
                     String scopeStr = "oauth2:https://www.googleapis.com/auth/calendar https://www.googleapis.com/auth/calendar.events";
                     Account var7 = account.getAccount();
                     if (var7 == null) {
                        return null;
                     }

                     Account androidAccount = var7;
                     account = GoogleAuthUtil.getToken(AuthManager.this.context, androidAccount, scopeStr);
                  } catch (Exception e) {
                     e.printStackTrace();
                     account = null;
                  }

                  return account;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, $completion);
   }

   @Nullable
   public final Object signOut(@NotNull Continuation $completion) {
      Continuation $continuation;
      label46: {
         if ($completion instanceof <undefinedtype>) {
            $continuation = (<undefinedtype>)$completion;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
               $continuation.label -= Integer.MIN_VALUE;
               break label46;
            }
         }

         $continuation = new ContinuationImpl($completion) {
            // $FF: synthetic field
            Object result;
            int label;

            @Nullable
            public final Object invokeSuspend(@NotNull Object $result) {
               this.result = $result;
               this.label |= Integer.MIN_VALUE;
               return AuthManager.this.signOut((Continuation)this);
            }
         };
      }

      Exception var10000;
      label39: {
         Object $result = $continuation.result;
         Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         switch ($continuation.label) {
            case 0:
               ResultKt.throwOnFailure($result);
               this.auth.signOut();

               try {
                  Task var9 = this.getGoogleSignInClient().signOut();
                  Intrinsics.checkNotNullExpressionValue(var9, "signOut(...)");
                  $continuation.label = 1;
                  var10 = TasksKt.await(var9, $continuation);
               } catch (Exception var7) {
                  var10000 = var7;
                  boolean var11 = false;
                  break label39;
               }

               if (var10 == var5) {
                  return var5;
               }
               break;
            case 1:
               try {
                  ResultKt.throwOnFailure($result);
                  break;
               } catch (Exception var8) {
                  var10000 = var8;
                  boolean var10001 = false;
                  break label39;
               }
            default:
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         try {
            return Unit.INSTANCE;
         } catch (Exception var6) {
            var10000 = var6;
            boolean var12 = false;
         }
      }

      Exception e = var10000;
      e.printStackTrace();
      return Unit.INSTANCE;
   }

   private static final GoogleSignInOptions googleSignInOptions_delegate$lambda$0(AuthManager this$0) {
      GoogleSignInOptions var10000 = (new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)).requestEmail().requestIdToken(this$0.serverClientId).requestScopes(new Scope("https://www.googleapis.com/auth/calendar"), new Scope[0]).requestScopes(new Scope("https://www.googleapis.com/auth/calendar.events"), new Scope[0]).build();
      Intrinsics.checkNotNullExpressionValue(var10000, "build(...)");
      return var10000;
   }

   private static final GoogleSignInClient googleSignInClient_delegate$lambda$1(AuthManager this$0) {
      GoogleSignInClient var10000 = GoogleSignIn.getClient(this$0.context, this$0.getGoogleSignInOptions());
      Intrinsics.checkNotNullExpressionValue(var10000, "getClient(...)");
      return var10000;
   }
}
