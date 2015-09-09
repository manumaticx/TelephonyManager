/**
 * TelephonyManager Android Module for Titanium
 * Copyright (c) 2015 by GOYYA Systems GmbH & Co.KG
 */
package com.goyya.telephonymanager;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import java.util.List;
import java.util.HashMap;

import android.os.Build;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.PhoneStateListener;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

@Kroll.module(name = "TelephonyManager", id = "com.goyya.telephonymanager")
public class TelephonyManagerModule extends KrollModule {

	private static final String LCAT = "TelephonyManagerModule";
	private static final boolean DBG = TiConfig.LOGD;
	private static TelephonyManager tm;
	private PhoneStateListener psl;
	private int events = PhoneStateListener.LISTEN_NONE;

	// constants
	@Kroll.constant
	public static final String EVENT_CALL_FORWARDING_INDICATOR = "callForwardingIndicator";
	@Kroll.constant
	public static final String EVENT_CALL_STATE = "callState";
	@Kroll.constant
	public static final String EVENT_CELL_INFO = "cellInfo";
	@Kroll.constant
	public static final String EVENT_CELL_LOCATION = "cellLocation";
	@Kroll.constant
	public static final String EVENT_DATA_ACTIVITY = "dataActivity";
	@Kroll.constant
	public static final String EVENT_DATA_CONNECTION_STATE = "dataConnectionState";
	@Kroll.constant
	public static final String EVENT_MESSAGE_WAITING_INDICATOR = "messageWaitingIndicator";
	@Kroll.constant
	public static final String EVENT_SERVICE_STATE = "serviceState";
	@Kroll.constant
	public static final String EVENT_SIGNAL_STRENGTHS = "signalStrengths";

	@Kroll.constant
	public static final int CALL_STATE_RINGING = TelephonyManager.CALL_STATE_RINGING;
	@Kroll.constant
	public static final int CALL_STATE_OFFHOOK = TelephonyManager.CALL_STATE_OFFHOOK;
	@Kroll.constant
	public static final int CALL_STATE_IDLE = TelephonyManager.CALL_STATE_IDLE;

	@Kroll.constant
	public static final int DATA_ACTIVITY_NONE = TelephonyManager.DATA_ACTIVITY_NONE;
	@Kroll.constant
	public static final int DATA_ACTIVITY_IN = TelephonyManager.DATA_ACTIVITY_IN;
	@Kroll.constant
	public static final int DATA_ACTIVITY_OUT = TelephonyManager.DATA_ACTIVITY_OUT;
	@Kroll.constant
	public static final int DATA_ACTIVITY_INOUT = TelephonyManager.DATA_ACTIVITY_INOUT;
	@Kroll.constant
	public static final int DATA_ACTIVITY_DORMANT = TelephonyManager.DATA_ACTIVITY_DORMANT;

	@Kroll.constant
	public static final int PHONE_TYPE_NONE = TelephonyManager.PHONE_TYPE_NONE;
	@Kroll.constant
	public static final int PHONE_TYPE_GSM = TelephonyManager.PHONE_TYPE_GSM;
	@Kroll.constant
	public static final int PHONE_TYPE_CDMA = TelephonyManager.PHONE_TYPE_CDMA;
	@Kroll.constant
	public static final int PHONE_TYPE_SIP = TelephonyManager.PHONE_TYPE_SIP;

	@Kroll.constant
	public static final int SIM_STATE_UNKNOWN = TelephonyManager.SIM_STATE_UNKNOWN;
	@Kroll.constant
	public static final int SIM_STATE_ABSENT = TelephonyManager.SIM_STATE_ABSENT;
	@Kroll.constant
	public static final int SIM_STATE_PIN_REQUIRED = TelephonyManager.SIM_STATE_PIN_REQUIRED;
	@Kroll.constant
	public static final int SIM_STATE_PUK_REQUIRED = TelephonyManager.SIM_STATE_PUK_REQUIRED;
	@Kroll.constant
	public static final int SIM_STATE_NETWORK_LOCKED = TelephonyManager.SIM_STATE_NETWORK_LOCKED;
	@Kroll.constant
	public static final int SIM_STATE_READY = TelephonyManager.SIM_STATE_READY;

	public TelephonyManagerModule() {
		super();
	}

	private TelephonyManager getManager() {
		if (tm != null) {
			return tm;
		}

		tm = (TelephonyManager) TiApplication.getAppRootOrCurrentActivity()
				.getSystemService(Context.TELEPHONY_SERVICE);
		return tm;
	}

	private PhoneStateListener getListener() {
		if (psl != null) {
			return psl;
		}

		psl = new PhoneStateListener() {

			@Override
			public void onCallForwardingIndicatorChanged(boolean cfi) {
				if (hasListeners(EVENT_CALL_FORWARDING_INDICATOR)) {
					HashMap<String, Object> event = new HashMap<String, Object>();
					event.put("cfi", cfi);
					fireEvent(EVENT_CALL_FORWARDING_INDICATOR, event);
				}
			}

			@Override
			public void onCallStateChanged(int state, String incomingNumber) {
				if (hasListeners(EVENT_CALL_STATE)) {
					HashMap<String, Object> event = new HashMap<String, Object>();
					event.put("incomingNumber", incomingNumber);
					fireEvent(EVENT_CALL_STATE, event);
				}
			}

			@Override
			public void onCellInfoChanged(List<CellInfo> cellInfo) {
				if (hasListeners(EVENT_CELL_INFO)) {
					HashMap<String, Object> event = new HashMap<String, Object>();
					// TODO: add helper to convert CellInfo
					fireEvent(EVENT_CELL_INFO, event);
				}
			}

			@Override
			public void onCellLocationChanged(CellLocation location) {
				if (hasListeners(EVENT_CELL_LOCATION)) {
					HashMap<String, Object> event = new HashMap<String, Object>();
					// TODO: add helper to convert CellLocation
					fireEvent(EVENT_CELL_LOCATION, event);
				}
			}

			@Override
			public void onDataActivity(int direction) {
				if (hasListeners(EVENT_DATA_ACTIVITY)) {
					HashMap<String, Object> event = new HashMap<String, Object>();
					event.put("direction", direction);
					fireEvent(EVENT_DATA_ACTIVITY, event);
				}
			}

			@Override
			public void onDataConnectionStateChanged(int state) {
				if (hasListeners(EVENT_DATA_CONNECTION_STATE)) {
					HashMap<String, Object> event = new HashMap<String, Object>();
					event.put("state", state);
					fireEvent(EVENT_DATA_CONNECTION_STATE, event);
				}
			}

			@Override
			public void onDataConnectionStateChanged(int state, int networkType) {
				if (hasListeners(EVENT_DATA_CONNECTION_STATE)) {
					HashMap<String, Object> event = new HashMap<String, Object>();
					event.put("state", state);
					event.put("networkType", networkType);
					fireEvent(EVENT_DATA_CONNECTION_STATE, event);
				}
			}

			@Override
			public void onMessageWaitingIndicatorChanged(boolean mwi) {
				if (hasListeners(EVENT_MESSAGE_WAITING_INDICATOR)) {
					HashMap<String, Object> event = new HashMap<String, Object>();
					event.put("mwi", mwi);
					fireEvent(EVENT_MESSAGE_WAITING_INDICATOR, event);
				}
			}

			@Override
			public void onServiceStateChanged(ServiceState serviceState) {
				if (hasListeners(EVENT_SERVICE_STATE)) {
					HashMap<String, Object> event = new HashMap<String, Object>();
					// TODO: add helper to convert ServiceState
					fireEvent(EVENT_SERVICE_STATE, event);
				}
			}

			@Override
			public void onSignalStrengthsChanged(SignalStrength signalStrength) {
				if (hasListeners(EVENT_SIGNAL_STRENGTHS)) {
					HashMap<String, Object> event = new HashMap<String, Object>();
					// TODO: add helper to convert SignalStrength
					fireEvent(EVENT_SIGNAL_STRENGTHS, event);
				}
			}
		};

		return psl;
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {

	}

	@Kroll.method
	@Kroll.getProperty
	public int getCallState() {
		return getManager().getCallState();
	}

	@Kroll.method
	@Kroll.getProperty
	public int getDataActivity() {
		return getManager().getDataActivity();
	}

	@Kroll.method
	@Kroll.getProperty
	public int getDataState() {
		return getManager().getDataState();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getDeviceId() {
		return getManager().getDeviceId();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getDeviceSoftwareVersion() {
		return getManager().getDeviceSoftwareVersion();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getGroupIdLevel1() {
		return getManager().getGroupIdLevel1();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getLine1Number() {
		return getManager().getLine1Number();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getMmsUAProfUrl() {
		return getManager().getMmsUAProfUrl();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getMmsUserAgent() {
		return getManager().getMmsUserAgent();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getNetworkCountryIso() {
		return getManager().getNetworkCountryIso();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getNetworkOperator() {
		return getManager().getNetworkOperator();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getNetworkOperatorName() {
		return getManager().getNetworkOperatorName();
	}

	@Kroll.method
	@Kroll.getProperty
	public int getNetworkType() {
		return getManager().getNetworkType();
	}

	@Kroll.method
	@Kroll.getProperty
	public int getPhoneType() {
		return getManager().getPhoneType();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getSimCountryIso() {
		return getManager().getSimCountryIso();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getSimOperator() {
		return getManager().getSimOperator();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getSimOperatorName() {
		return getManager().getSimOperatorName();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getSimSerialNumber() {
		return getManager().getSimSerialNumber();
	}

	@Kroll.method
	@Kroll.getProperty
	public int getSimState() {
		return getManager().getSimState();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getSubscriberId() {
		return getManager().getSubscriberId();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getVoiceMailAlphaTag() {
		return getManager().getVoiceMailAlphaTag();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getVoiceMailNumber() {
		return getManager().getVoiceMailNumber();
	}

	@Kroll.method
	@Kroll.getProperty
	public boolean getHasCarrierPrivileges() {
		if (Build.VERSION.SDK_INT >= 22) {
			return getManager().hasCarrierPrivileges();
		} else {
			return false;
		}
	}

	@Kroll.method
	@Kroll.getProperty
	public boolean getHasIccCard() {
		return getManager().hasIccCard();
	}

	@Kroll.method
	public boolean iccCloseLogicalChannel(int channel) {
		return getManager().iccCloseLogicalChannel(channel);
	}

	@Kroll.method
	@Kroll.getProperty
	public boolean getIsNetworkRoaming() {
		return getManager().isNetworkRoaming();
	}

	@Kroll.method
	@Kroll.getProperty
	public boolean getIsSmsCapable() {
		return getManager().isSmsCapable();
	}

	@Kroll.method
	@Kroll.getProperty
	public boolean getIsVoiceCapable() {
		return getManager().isVoiceCapable();
	}

	@Kroll.method
	public String sendEnvelopeWithStatus(String content) {
		return getManager().sendEnvelopeWithStatus(content);
	}

	@Kroll.method
	public boolean setLine1NumberForDisplay(String alphaTag, String number) {
		return getManager().setLine1NumberForDisplay(alphaTag, number);
	}

	@Kroll.method
	public boolean setOperatorBrandOverride(String brand) {
		return getManager().setOperatorBrandOverride(brand);
	}

	@Kroll.method
	public boolean setPreferredNetworkTypeToGlobal() {
		return getManager().setPreferredNetworkTypeToGlobal();
	}

	@Kroll.setProperty
	public boolean setVoiceMailNumber(String alphaTag, String number) {
		return getManager().setVoiceMailNumber(alphaTag, number);
	}

	// Event Listeners
	@Override
	public void listenerAdded(String type, int count, KrollProxy proxy) {
		events |= getEventFlag(type);
		getManager().listen(getListener(), events);
	}

	@Override
	public void listenerRemoved(String type, int count, KrollProxy proxy) {
		events &= ~getEventFlag(type);
		getManager().listen(getListener(), events);
	}

	private int getEventFlag(String eventName) {
		switch (eventName) {
		case EVENT_CALL_FORWARDING_INDICATOR:
			return PhoneStateListener.LISTEN_CALL_FORWARDING_INDICATOR;
		case EVENT_CALL_STATE:
			return PhoneStateListener.LISTEN_CALL_STATE;
		case EVENT_CELL_INFO:
			return PhoneStateListener.LISTEN_CELL_INFO;
		case EVENT_CELL_LOCATION:
			return PhoneStateListener.LISTEN_CELL_LOCATION;
		case EVENT_DATA_ACTIVITY:
			return PhoneStateListener.LISTEN_DATA_ACTIVITY;
		case EVENT_DATA_CONNECTION_STATE:
			return PhoneStateListener.LISTEN_DATA_CONNECTION_STATE;
		case EVENT_MESSAGE_WAITING_INDICATOR:
			return PhoneStateListener.LISTEN_MESSAGE_WAITING_INDICATOR;
		case EVENT_SERVICE_STATE:
			return PhoneStateListener.LISTEN_SERVICE_STATE;
		case EVENT_SIGNAL_STRENGTHS:
			return PhoneStateListener.LISTEN_SIGNAL_STRENGTHS;
		default:
			return PhoneStateListener.LISTEN_NONE;
		}
	}

}
