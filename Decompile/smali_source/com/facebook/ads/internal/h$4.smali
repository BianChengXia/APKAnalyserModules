.class Lcom/facebook/ads/internal/h$4;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/facebook/ads/internal/adapters/InterstitialAdapterListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/ads/internal/h;->n()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Runnable;

.field final synthetic b:Lcom/facebook/ads/internal/h;


# direct methods
.method constructor <init>(Lcom/facebook/ads/internal/h;Ljava/lang/Runnable;)V
    .registers 3

    iput-object p1, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    iput-object p2, p0, Lcom/facebook/ads/internal/h$4;->a:Ljava/lang/Runnable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onInterstitialAdClicked(Lcom/facebook/ads/internal/adapters/InterstitialAdapter;Ljava/lang/String;Z)V
    .registers 6

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v0}, Lcom/facebook/ads/internal/h;->d(Lcom/facebook/ads/internal/h;)V

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    iget-object v0, v0, Lcom/facebook/ads/internal/h;->a:Lcom/facebook/ads/internal/a;

    invoke-virtual {v0}, Lcom/facebook/ads/internal/a;->b()V

    invoke-static {p2}, Lcom/facebook/ads/internal/util/s;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_42

    const/4 v0, 0x1

    :goto_13
    if-eqz p3, :cond_41

    if-eqz v0, :cond_41

    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v1}, Lcom/facebook/ads/internal/h;->i(Lcom/facebook/ads/internal/h;)Lcom/facebook/ads/internal/dto/e;

    move-result-object v1

    iget-object v1, v1, Lcom/facebook/ads/internal/dto/e;->d:Landroid/content/Context;

    instance-of v1, v1, Landroid/app/Activity;

    if-nez v1, :cond_2f

    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    :cond_2f
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    iget-object v1, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v1}, Lcom/facebook/ads/internal/h;->i(Lcom/facebook/ads/internal/h;)Lcom/facebook/ads/internal/dto/e;

    move-result-object v1

    iget-object v1, v1, Lcom/facebook/ads/internal/dto/e;->d:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    :cond_41
    return-void

    :cond_42
    const/4 v0, 0x0

    goto :goto_13
.end method

.method public onInterstitialAdDismissed(Lcom/facebook/ads/internal/adapters/InterstitialAdapter;)V
    .registers 3

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v0}, Lcom/facebook/ads/internal/h;->d(Lcom/facebook/ads/internal/h;)V

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    iget-object v0, v0, Lcom/facebook/ads/internal/h;->a:Lcom/facebook/ads/internal/a;

    invoke-virtual {v0}, Lcom/facebook/ads/internal/a;->e()V

    return-void
.end method

.method public onInterstitialAdDisplayed(Lcom/facebook/ads/internal/adapters/InterstitialAdapter;)V
    .registers 3

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v0}, Lcom/facebook/ads/internal/h;->d(Lcom/facebook/ads/internal/h;)V

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    iget-object v0, v0, Lcom/facebook/ads/internal/h;->a:Lcom/facebook/ads/internal/a;

    invoke-virtual {v0}, Lcom/facebook/ads/internal/a;->d()V

    return-void
.end method

.method public onInterstitialAdLoaded(Lcom/facebook/ads/internal/adapters/InterstitialAdapter;)V
    .registers 4

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v0}, Lcom/facebook/ads/internal/h;->d(Lcom/facebook/ads/internal/h;)V

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v0}, Lcom/facebook/ads/internal/h;->e(Lcom/facebook/ads/internal/h;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/ads/internal/h$4;->a:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v0, p1}, Lcom/facebook/ads/internal/h;->b(Lcom/facebook/ads/internal/h;Lcom/facebook/ads/internal/adapters/AdAdapter;)Lcom/facebook/ads/internal/adapters/AdAdapter;

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    iget-object v0, v0, Lcom/facebook/ads/internal/h;->a:Lcom/facebook/ads/internal/a;

    invoke-virtual {v0}, Lcom/facebook/ads/internal/a;->a()V

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v0}, Lcom/facebook/ads/internal/h;->b(Lcom/facebook/ads/internal/h;)V

    return-void
.end method

.method public onInterstitialError(Lcom/facebook/ads/internal/adapters/InterstitialAdapter;Lcom/facebook/ads/AdError;)V
    .registers 5

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v0}, Lcom/facebook/ads/internal/h;->d(Lcom/facebook/ads/internal/h;)V

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v0}, Lcom/facebook/ads/internal/h;->e(Lcom/facebook/ads/internal/h;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/ads/internal/h$4;->a:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v0, p1}, Lcom/facebook/ads/internal/h;->a(Lcom/facebook/ads/internal/h;Lcom/facebook/ads/internal/adapters/AdAdapter;)V

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v0}, Lcom/facebook/ads/internal/h;->c(Lcom/facebook/ads/internal/h;)V

    return-void
.end method

.method public onInterstitialLoggingImpression(Lcom/facebook/ads/internal/adapters/InterstitialAdapter;)V
    .registers 3

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    invoke-static {v0}, Lcom/facebook/ads/internal/h;->d(Lcom/facebook/ads/internal/h;)V

    iget-object v0, p0, Lcom/facebook/ads/internal/h$4;->b:Lcom/facebook/ads/internal/h;

    iget-object v0, v0, Lcom/facebook/ads/internal/h;->a:Lcom/facebook/ads/internal/a;

    invoke-virtual {v0}, Lcom/facebook/ads/internal/a;->c()V

    return-void
.end method
