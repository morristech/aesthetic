/*
 * Licensed under Apache-2.0
 *
 * Designed and developed by Aidan Follestad (@afollestad)
 */
package com.afollestad.aesthetic.actions

import android.support.v7.widget.CardView
import android.view.View
import io.reactivex.exceptions.Exceptions
import io.reactivex.observers.DisposableObserver

/** @author Aidan Follestad (afollestad) */
internal class ViewBackgroundSubscriber constructor(private val view: View) :
    DisposableObserver<Int>() {

  override fun onError(e: Throwable) {
    throw Exceptions.propagate(e)
  }

  override fun onComplete() {}

  override fun onNext(color: Int) {
    if (view is CardView) {
      view.setCardBackgroundColor(color)
    } else {
      view.setBackgroundColor(color)
    }
  }
}
