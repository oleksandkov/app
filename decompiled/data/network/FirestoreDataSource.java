package com.example.data.network;

import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.WriteBatch;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.tasks.TasksKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J(\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000e0\rH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"},
   d2 = {"Lcom/example/data/network/FirestoreDataSource;", "", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "<init>", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/google/firebase/auth/FirebaseAuth;)V", "getUserId", "", "syncTasksToCloud", "", "tasks", "", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nFirestoreDataSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirestoreDataSource.kt\ncom/example/data/network/FirestoreDataSource\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n1869#2,2:37\n*S KotlinDebug\n*F\n+ 1 FirestoreDataSource.kt\ncom/example/data/network/FirestoreDataSource\n*L\n29#1:37,2\n*E\n"})
public final class FirestoreDataSource {
   @NotNull
   private final FirebaseFirestore firestore;
   @NotNull
   private final FirebaseAuth auth;
   public static final int $stable = 8;

   public FirestoreDataSource(@NotNull FirebaseFirestore firestore, @NotNull FirebaseAuth auth) {
      Intrinsics.checkNotNullParameter(firestore, "firestore");
      Intrinsics.checkNotNullParameter(auth, "auth");
      super();
      this.firestore = firestore;
      this.auth = auth;
   }

   private final String getUserId() {
      FirebaseUser var10000 = this.auth.getCurrentUser();
      return var10000 != null ? var10000.getUid() : null;
   }

   @Nullable
   public final Object syncTasksToCloud(@NotNull List tasks, @NotNull Continuation $completion) {
      String var10000 = this.getUserId();
      if (var10000 == null) {
         return Unit.INSTANCE;
      } else {
         String uid = var10000;
         WriteBatch var12 = this.firestore.batch();
         Intrinsics.checkNotNullExpressionValue(var12, "batch(...)");
         WriteBatch batch = var12;
         Iterable var5 = (Iterable)tasks;
         int var6 = 0;

         for(Object var8 : var5) {
            Map var9 = (Map)var8;
            int var10 = 0;
            DocumentReference var13 = this.firestore.collection("users").document(uid).collection("tasks").document(String.valueOf(var9.get("id")));
            Intrinsics.checkNotNullExpressionValue(var13, "document(...)");
            DocumentReference var11 = var13;
            batch.set(var11, var9);
         }

         Task var14 = batch.commit();
         Intrinsics.checkNotNullExpressionValue(var14, "commit(...)");
         Object var15 = TasksKt.await(var14, $completion);
         return var15 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var15 : Unit.INSTANCE;
      }
   }
}
