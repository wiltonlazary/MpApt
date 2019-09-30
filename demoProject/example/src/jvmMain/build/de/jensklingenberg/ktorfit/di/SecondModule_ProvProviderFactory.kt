package de.jensklingenberg.ktorfit.di

import de.jensklingenberg.knife.internal.Factory
import de.jensklingenberg.knife.internal.MPreconditions.Companion.checkNotNull
import kotlin.String

class SecondModule_ProvProviderFactory(
  private val instance: SecondModule
) : Factory<String> {
  override fun get() = provProvider( instance)

  companion object {
    fun provProvider(instance: SecondModule): String {
      val errorMessage = "Cannot return null from a non-@Nullable @Provides method"
      return checkNotNull(instance.provProvider(), errorMessage  )
    }

    fun create(instance: SecondModule) = SecondModule_ProvProviderFactory( instance)
  }
}