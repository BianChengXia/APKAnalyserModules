.class public final Lcom/google/android/gms/internal/zzfs;
.super Lcom/google/android/gms/dynamic/zzg;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzgk;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzfs$zza;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/dynamic/zzg",
        "<",
        "Lcom/google/android/gms/internal/zzfo;",
        ">;"
    }
.end annotation


# static fields
.field private static final zzCo:Lcom/google/android/gms/internal/zzfs;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/android/gms/internal/zzfs;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzfs;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/zzfs;->zzCo:Lcom/google/android/gms/internal/zzfs;

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    const-string v0, "com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl"

    invoke-direct {p0, v0}, Lcom/google/android/gms/dynamic/zzg;-><init>(Ljava/lang/String;)V

    return-void
.end method

.method private static zzc(Landroid/app/Activity;)Z
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/android/gms/internal/zzfs$zza;
        }
    .end annotation

    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "com.google.android.gms.ads.internal.purchase.useClientJar"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_14

    new-instance v0, Lcom/google/android/gms/internal/zzfs$zza;

    const-string v1, "InAppPurchaseManager requires the useClientJar flag in intent extras."

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzfs$zza;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_14
    const-string v1, "com.google.android.gms.ads.internal.purchase.useClientJar"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public static zze(Landroid/app/Activity;)Lcom/google/android/gms/internal/zzfn;
    .registers 2

    :try_start_0
    invoke-static {p0}, Lcom/google/android/gms/internal/zzfs;->zzc(Landroid/app/Activity;)Z

    move-result v0

    if-eqz v0, :cond_11

    const-string v0, "Using AdOverlay from the client jar."

    invoke-static {v0}, Lcom/google/android/gms/ads/internal/util/client/zzb;->zzaC(Ljava/lang/String;)V

    new-instance v0, Lcom/google/android/gms/ads/internal/purchase/zze;

    invoke-direct {v0, p0}, Lcom/google/android/gms/ads/internal/purchase/zze;-><init>(Landroid/app/Activity;)V

    :goto_10
    return-object v0

    :cond_11
    sget-object v0, Lcom/google/android/gms/internal/zzfs;->zzCo:Lcom/google/android/gms/internal/zzfs;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzfs;->zzf(Landroid/app/Activity;)Lcom/google/android/gms/internal/zzfn;
    :try_end_16
    .catch Lcom/google/android/gms/internal/zzfs$zza; {:try_start_0 .. :try_end_16} :catch_18

    move-result-object v0

    goto :goto_10

    :catch_18
    move-exception v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfs$zza;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/ads/internal/util/client/zzb;->zzaE(Ljava/lang/String;)V

    const/4 v0, 0x0

    goto :goto_10
.end method

.method private zzf(Landroid/app/Activity;)Lcom/google/android/gms/internal/zzfn;
    .registers 5

    const/4 v1, 0x0

    :try_start_1
    invoke-static {p1}, Lcom/google/android/gms/dynamic/zze;->zzx(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/zzd;

    move-result-object v2

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzfs;->zzar(Landroid/content/Context;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzfo;

    invoke-interface {v0, v2}, Lcom/google/android/gms/internal/zzfo;->zzf(Lcom/google/android/gms/dynamic/zzd;)Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/zzfn$zza;->zzP(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzfn;
    :try_end_12
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_12} :catch_14
    .catch Lcom/google/android/gms/dynamic/zzg$zza; {:try_start_1 .. :try_end_12} :catch_1c

    move-result-object v0

    :goto_13
    return-object v0

    :catch_14
    move-exception v0

    const-string v2, "Could not create remote InAppPurchaseManager."

    invoke-static {v2, v0}, Lcom/google/android/gms/ads/internal/util/client/zzb;->zzd(Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    goto :goto_13

    :catch_1c
    move-exception v0

    const-string v2, "Could not create remote InAppPurchaseManager."

    invoke-static {v2, v0}, Lcom/google/android/gms/ads/internal/util/client/zzb;->zzd(Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    goto :goto_13
.end method


# virtual methods
.method protected zzT(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzfo;
    .registers 3

    invoke-static {p1}, Lcom/google/android/gms/internal/zzfo$zza;->zzQ(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzfo;

    move-result-object v0

    return-object v0
.end method

.method protected synthetic zzd(Landroid/os/IBinder;)Ljava/lang/Object;
    .registers 3

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzfs;->zzT(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzfo;

    move-result-object v0

    return-object v0
.end method
