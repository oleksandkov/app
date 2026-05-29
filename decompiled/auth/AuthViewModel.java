package com.example.auth;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.tasks.TasksKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u001e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"},
   d2 = {"Lcom/example/auth/AuthViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "authManager", "Lcom/example/auth/AuthManager;", "getAuthManager", "()Lcom/example/auth/AuthManager;", "_authState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/auth/AuthState;", "authState", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "checkCurrentSession", "", "loginWithEmail", "email", "", "password", "registerWithEmail", "nickname", "handleGoogleSignInResult", "intent", "Landroid/content/Intent;", "signOut", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class AuthViewModel extends AndroidViewModel {
   @NotNull
   private final FirebaseAuth auth;
   @NotNull
   private final AuthManager authManager;
   @NotNull
   private final MutableStateFlow _authState;
   @NotNull
   private final StateFlow authState;
   public static final int $stable = 8;

   public AuthViewModel(@NotNull Application application) {
      Intrinsics.checkNotNullParameter(application, "application");
      super(application);
      FirebaseAuth var10001 = FirebaseAuth.getInstance();
      Intrinsics.checkNotNullExpressionValue(var10001, "getInstance(...)");
      this.auth = var10001;
      this.authManager = new AuthManager((Context)application, this.auth);
      this._authState = StateFlowKt.MutableStateFlow(AuthState.Idle.INSTANCE);
      this.authState = (StateFlow)this._authState;
      this.checkCurrentSession();
   }

   @NotNull
   public final AuthManager getAuthManager() {
      return this.authManager;
   }

   @NotNull
   public final StateFlow getAuthState() {
      return this.authState;
   }

   private final void checkCurrentSession() {
      FirebaseUser user = this.auth.getCurrentUser();
      if (user != null) {
         MutableStateFlow var10000 = this._authState;
         AuthState.Success var10001 = new AuthState.Success;
         String var10003 = user.getEmail();
         if (var10003 == null) {
            var10003 = "";
         }

         String var10004 = user.getDisplayName();
         if (var10004 == null) {
            var10004 = "User";
         }

         var10001.<init>(var10003, var10004);
         var10000.setValue(var10001);
      }

   }

   public final void loginWithEmail(@NotNull final String email, @NotNull final String password) {
      Intrinsics.checkNotNullParameter(email, "email");
      Intrinsics.checkNotNullParameter(password, "password");
      this._authState.setValue(AuthState.Loading.INSTANCE);
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Exception var10000;
            label49: {
               Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               Object var9;
               switch (this.label) {
                  case 0:
                     ResultKt.throwOnFailure($result);

                     try {
                        Task var10 = AuthViewModel.this.auth.signInWithEmailAndPassword(email, password);
                        Intrinsics.checkNotNullExpressionValue(var10, "signInWithEmailAndPassword(...)");
                        Continuation var14 = (Continuation)this;
                        this.label = 1;
                        var9 = TasksKt.await(var10, var14);
                     } catch (Exception var6) {
                        var10000 = var6;
                        boolean var13 = false;
                        break label49;
                     }

                     if (var9 == var4) {
                        return var4;
                     }
                     break;
                  case 1:
                     try {
                        ResultKt.throwOnFailure($result);
                        var9 = $result;
                        break;
                     } catch (Exception var7) {
                        var10000 = var7;
                        boolean var10001 = false;
                        break label49;
                     }
                  default:
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               try {
                  AuthResult result = (AuthResult)var9;
                  FirebaseUser user = result.getUser();
                  if (user != null) {
                     MutableStateFlow var12 = AuthViewModel.this._authState;
                     AuthState.Success var17 = new AuthState.Success;
                     String var18 = user.getEmail();
                     if (var18 == null) {
                        var18 = "";
                     }

                     String var10004 = user.getDisplayName();
                     if (var10004 == null) {
                        var10004 = "User";
                     }

                     var17.<init>(var18, var10004);
                     var12.setValue(var17);
                  } else {
                     AuthViewModel.this._authState.setValue(new AuthState.Error("Sign in failed"));
                  }

                  return Unit.INSTANCE;
               } catch (Exception var5) {
                  var10000 = var5;
                  boolean var15 = false;
               }
            }

            Exception e = var10000;
            MutableStateFlow var11 = AuthViewModel.this._authState;
            AuthState.Error var16 = new AuthState.Error;
            String var10003 = e.getLocalizedMessage();
            if (var10003 == null) {
               var10003 = "Unknown error occurred";
            }

            var16.<init>(var10003);
            var11.setValue(var16);
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

   public final void registerWithEmail(@NotNull final String email, @NotNull final String password, @NotNull final String nickname) {
      Intrinsics.checkNotNullParameter(email, "email");
      Intrinsics.checkNotNullParameter(password, "password");
      Intrinsics.checkNotNullParameter(nickname, "nickname");
      this._authState.setValue(AuthState.Loading.INSTANCE);
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         Object L$0;
         Object L$1;
         Object L$2;
         int label;

         public final Object invokeSuspend(Object $result) {
            Exception var10000;
            label68: {
               FirebaseUser user;
               label73: {
                  Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  Object var15;
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);

                        try {
                           Task var16 = AuthViewModel.this.auth.createUserWithEmailAndPassword(email, password);
                           Intrinsics.checkNotNullExpressionValue(var16, "createUserWithEmailAndPassword(...)");
                           Continuation var24 = (Continuation)this;
                           this.label = 1;
                           var15 = TasksKt.await(var16, var24);
                        } catch (Exception var9) {
                           var10000 = var9;
                           boolean var23 = false;
                           break label68;
                        }

                        if (var15 == var5) {
                           return var5;
                        }
                        break;
                     case 1:
                        try {
                           ResultKt.throwOnFailure($result);
                           var15 = $result;
                           break;
                        } catch (Exception var10) {
                           var10000 = var10;
                           boolean var22 = false;
                           break label68;
                        }
                     case 2:
                        UserProfileChangeRequest profileUpdates = (UserProfileChangeRequest)this.L$2;
                        user = (FirebaseUser)this.L$1;
                        AuthResult result = (AuthResult)this.L$0;

                        try {
                           ResultKt.throwOnFailure($result);
                           break label73;
                        } catch (Exception var8) {
                           var10000 = var8;
                           boolean var10001 = false;
                           break label68;
                        }
                     default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  label65: {
                     try {
                        AuthResult result = (AuthResult)var15;
                        user = result.getUser();
                        if (user != null) {
                           UserProfileChangeRequest var17 = (new UserProfileChangeRequest.Builder()).setDisplayName(nickname).build();
                           Intrinsics.checkNotNullExpressionValue(var17, "build(...)");
                           UserProfileChangeRequest profileUpdates = var17;
                           Task var18 = user.updateProfile(profileUpdates);
                           Intrinsics.checkNotNullExpressionValue(var18, "updateProfile(...)");
                           Continuation var27 = (Continuation)this;
                           this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                           this.L$1 = user;
                           this.L$2 = SpillingKt.nullOutSpilledVariable(profileUpdates);
                           this.label = 2;
                           var15 = TasksKt.await(var18, var27);
                           break label65;
                        }
                     } catch (Exception var11) {
                        var10000 = var11;
                        boolean var25 = false;
                        break label68;
                     }

                     try {
                        AuthViewModel.this._authState.setValue(new AuthState.Error("Registration failed"));
                        return Unit.INSTANCE;
                     } catch (Exception var7) {
                        var10000 = var7;
                        boolean var26 = false;
                        break label68;
                     }
                  }

                  if (var15 == var5) {
                     return var5;
                  }
               }

               try {
                  MutableStateFlow var21 = AuthViewModel.this._authState;
                  AuthState.Success var30 = new AuthState.Success;
                  String var31 = user.getEmail();
                  if (var31 == null) {
                     var31 = "";
                  }

                  var30.<init>(var31, nickname);
                  var21.setValue(var30);
                  return Unit.INSTANCE;
               } catch (Exception var6) {
                  var10000 = var6;
                  boolean var28 = false;
               }
            }

            Exception e = var10000;
            MutableStateFlow var20 = AuthViewModel.this._authState;
            AuthState.Error var29 = new AuthState.Error;
            String var10003 = e.getLocalizedMessage();
            if (var10003 == null) {
               var10003 = "Registration failed";
            }

            var29.<init>(var10003);
            var20.setValue(var29);
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

   public final void handleGoogleSignInResult(@Nullable final Intent intent) {
      this._authState.setValue(AuthState.Loading.INSTANCE);
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Object var10000;
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  var10000 = AuthViewModel.this.getAuthManager();
                  Intent var10001 = intent;
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  var10000 = (AuthManager)var10000.handleGoogleSignInResult(var10001, var10002);
                  if (var10000 == var4) {
                     return var4;
                  }
                  break;
               case 1:
                  ResultKt.throwOnFailure($result);
                  var10000 = (AuthManager)$result;
                  break;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            boolean success = (Boolean)var10000;
            if (success) {
               FirebaseUser user = AuthViewModel.this.auth.getCurrentUser();
               if (user != null) {
                  MutableStateFlow var6 = AuthViewModel.this._authState;
                  AuthState.Success var7 = new AuthState.Success;
                  String var10003 = user.getEmail();
                  if (var10003 == null) {
                     var10003 = "";
                  }

                  String var10004 = user.getDisplayName();
                  if (var10004 == null) {
                     var10004 = "Google User";
                  }

                  var7.<init>(var10003, var10004);
                  var6.setValue(var7);
               } else {
                  AuthViewModel.this._authState.setValue(new AuthState.Error("Google Auth succeeded but user is null"));
               }
            } else {
               AuthViewModel.this._authState.setValue(new AuthState.Error("Google Sign-In failed or cancelled"));
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

   public final void signOut() {
      this._authState.setValue(AuthState.Idle.INSTANCE);
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  AuthManager var10000 = AuthViewModel.this.getAuthManager();
                  Continuation var10001 = (Continuation)this;
                  this.label = 1;
                  if (var10000.signOut(var10001) == var2) {
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
}
