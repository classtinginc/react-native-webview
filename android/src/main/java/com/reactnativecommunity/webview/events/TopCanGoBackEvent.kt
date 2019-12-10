package com.reactnativecommunity.webview.events

import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event
import com.facebook.react.uimanager.events.RCTEventEmitter

/**
 * Event emitted when there is getCanGoBack command called.
 */
class TopCanGoBackEvent(viewId: Int, private val mEventData: WritableMap) : Event<TopCanGoBackEvent>(viewId) {
  companion object {
    const val EVENT_NAME = "topCanGoBackEvent"
  }

  override fun getEventName(): String = EVENT_NAME

  override fun canCoalesce(): Boolean = false

  override fun getCoalescingKey(): Short = 0

  override fun dispatch(rctEventEmitter: RCTEventEmitter) {
    rctEventEmitter.receiveEvent(viewTag, EVENT_NAME, mEventData)
  }
}
