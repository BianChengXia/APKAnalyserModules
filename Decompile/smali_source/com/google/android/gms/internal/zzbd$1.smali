.class Lcom/google/android/gms/internal/zzbd$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzbd;->zza(Ljava/lang/String;Lorg/json/JSONObject;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzru:Ljava/lang/String;

.field final synthetic zzrv:Lorg/json/JSONObject;

.field final synthetic zzrw:Lcom/google/android/gms/internal/zzbd;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzbd;Ljava/lang/String;Lorg/json/JSONObject;)V
    .registers 4

    iput-object p1, p0, Lcom/google/android/gms/internal/zzbd$1;->zzrw:Lcom/google/android/gms/internal/zzbd;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzbd$1;->zzru:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzbd$1;->zzrv:Lorg/json/JSONObject;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 4

    iget-object v0, p0, Lcom/google/android/gms/internal/zzbd$1;->zzrw:Lcom/google/android/gms/internal/zzbd;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzbd;->zza(Lcom/google/android/gms/internal/zzbd;)Lcom/google/android/gms/internal/zzip;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzbd$1;->zzru:Ljava/lang/String;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzbd$1;->zzrv:Lorg/json/JSONObject;

    invoke-interface {v0, v1, v2}, Lcom/google/android/gms/internal/zzip;->zza(Ljava/lang/String;Lorg/json/JSONObject;)V

    return-void
.end method