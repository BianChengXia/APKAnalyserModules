.class public final Lrx/exceptions/Exceptions;
.super Ljava/lang/Object;
.source "Exceptions.java"


# direct methods
.method public static addCause(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    .registers 6
    .param p0, "e"    # Ljava/lang/Throwable;
    .param p1, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 111
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 113
    .local v2, "seenCauses":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Throwable;>;"
    const/4 v0, 0x0

    .line 114
    .local v0, "i":I
    :goto_6
    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v3

    if-eqz v3, :cond_23

    .line 115
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "i":I
    .local v1, "i":I
    const/16 v3, 0x19

    if-lt v0, v3, :cond_14

    move v0, v1

    .line 134
    .end local v1    # "i":I
    .restart local v0    # "i":I
    :goto_13
    return-void

    .line 119
    .end local v0    # "i":I
    .restart local v1    # "i":I
    :cond_14
    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object p0

    .line 120
    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_29

    move v0, v1

    .line 128
    .end local v1    # "i":I
    .restart local v0    # "i":I
    :cond_23
    :try_start_23
    invoke-virtual {p0, p1}, Ljava/lang/Throwable;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    :try_end_26
    .catch Ljava/lang/Throwable; {:try_start_23 .. :try_end_26} :catch_27

    goto :goto_13

    .line 129
    :catch_27
    move-exception v3

    goto :goto_13

    .line 123
    .end local v0    # "i":I
    .restart local v1    # "i":I
    :cond_29
    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    move v0, v1

    .end local v1    # "i":I
    .restart local v0    # "i":I
    goto :goto_6
.end method

.method public static getFinalCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    .registers 4
    .param p0, "e"    # Ljava/lang/Throwable;

    .prologue
    .line 145
    const/4 v0, 0x0

    .line 146
    .local v0, "i":I
    :goto_1
    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v2

    if-eqz v2, :cond_15

    .line 147
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "i":I
    .local v1, "i":I
    const/16 v2, 0x19

    if-lt v0, v2, :cond_16

    .line 149
    new-instance p0, Ljava/lang/RuntimeException;

    .end local p0    # "e":Ljava/lang/Throwable;
    const-string v2, "Stack too deep to get final cause"

    invoke-direct {p0, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    move v0, v1

    .line 153
    .end local v1    # "i":I
    .restart local v0    # "i":I
    :cond_15
    return-object p0

    .line 151
    .end local v0    # "i":I
    .restart local v1    # "i":I
    .restart local p0    # "e":Ljava/lang/Throwable;
    :cond_16
    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object p0

    move v0, v1

    .end local v1    # "i":I
    .restart local v0    # "i":I
    goto :goto_1
.end method

.method public static throwIfAny(Ljava/util/List;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<+",
            "Ljava/lang/Throwable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 164
    .local p0, "exceptions":Ljava/util/List;, "Ljava/util/List<+Ljava/lang/Throwable;>;"
    if-eqz p0, :cond_32

    invoke-interface {p0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_32

    .line 165
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_2a

    .line 166
    const/4 v1, 0x0

    invoke-interface {p0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Throwable;

    .line 169
    .local v0, "t":Ljava/lang/Throwable;
    instance-of v1, v0, Ljava/lang/RuntimeException;

    if-eqz v1, :cond_1d

    .line 170
    check-cast v0, Ljava/lang/RuntimeException;

    .end local v0    # "t":Ljava/lang/Throwable;
    throw v0

    .line 171
    .restart local v0    # "t":Ljava/lang/Throwable;
    :cond_1d
    instance-of v1, v0, Ljava/lang/Error;

    if-eqz v1, :cond_24

    .line 172
    check-cast v0, Ljava/lang/Error;

    .end local v0    # "t":Ljava/lang/Throwable;
    throw v0

    .line 174
    .restart local v0    # "t":Ljava/lang/Throwable;
    :cond_24
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 177
    .end local v0    # "t":Ljava/lang/Throwable;
    :cond_2a
    new-instance v1, Lrx/exceptions/CompositeException;

    const-string v2, "Multiple exceptions"

    invoke-direct {v1, v2, p0}, Lrx/exceptions/CompositeException;-><init>(Ljava/lang/String;Ljava/util/Collection;)V

    throw v1

    .line 180
    :cond_32
    return-void
.end method

.method public static throwIfFatal(Ljava/lang/Throwable;)V
    .registers 3
    .param p0, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 77
    instance-of v1, p0, Lrx/exceptions/OnErrorNotImplementedException;

    if-eqz v1, :cond_7

    .line 78
    check-cast p0, Lrx/exceptions/OnErrorNotImplementedException;

    .end local p0    # "t":Ljava/lang/Throwable;
    throw p0

    .line 79
    .restart local p0    # "t":Ljava/lang/Throwable;
    :cond_7
    instance-of v1, p0, Lrx/exceptions/OnErrorFailedException;

    if-eqz v1, :cond_1c

    move-object v1, p0

    .line 80
    check-cast v1, Lrx/exceptions/OnErrorFailedException;

    invoke-virtual {v1}, Lrx/exceptions/OnErrorFailedException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .line 81
    .local v0, "cause":Ljava/lang/Throwable;
    instance-of v1, v0, Ljava/lang/RuntimeException;

    if-eqz v1, :cond_19

    .line 82
    check-cast v0, Ljava/lang/RuntimeException;

    .end local v0    # "cause":Ljava/lang/Throwable;
    throw v0

    .line 84
    .restart local v0    # "cause":Ljava/lang/Throwable;
    :cond_19
    check-cast p0, Lrx/exceptions/OnErrorFailedException;

    .end local p0    # "t":Ljava/lang/Throwable;
    throw p0

    .line 88
    .end local v0    # "cause":Ljava/lang/Throwable;
    .restart local p0    # "t":Ljava/lang/Throwable;
    :cond_1c
    instance-of v1, p0, Ljava/lang/StackOverflowError;

    if-eqz v1, :cond_23

    .line 89
    check-cast p0, Ljava/lang/StackOverflowError;

    .end local p0    # "t":Ljava/lang/Throwable;
    throw p0

    .line 90
    .restart local p0    # "t":Ljava/lang/Throwable;
    :cond_23
    instance-of v1, p0, Ljava/lang/VirtualMachineError;

    if-eqz v1, :cond_2a

    .line 91
    check-cast p0, Ljava/lang/VirtualMachineError;

    .end local p0    # "t":Ljava/lang/Throwable;
    throw p0

    .line 92
    .restart local p0    # "t":Ljava/lang/Throwable;
    :cond_2a
    instance-of v1, p0, Ljava/lang/ThreadDeath;

    if-eqz v1, :cond_31

    .line 93
    check-cast p0, Ljava/lang/ThreadDeath;

    .end local p0    # "t":Ljava/lang/Throwable;
    throw p0

    .line 94
    .restart local p0    # "t":Ljava/lang/Throwable;
    :cond_31
    instance-of v1, p0, Ljava/lang/LinkageError;

    if-eqz v1, :cond_38

    .line 95
    check-cast p0, Ljava/lang/LinkageError;

    .end local p0    # "t":Ljava/lang/Throwable;
    throw p0

    .line 97
    .restart local p0    # "t":Ljava/lang/Throwable;
    :cond_38
    return-void
.end method
