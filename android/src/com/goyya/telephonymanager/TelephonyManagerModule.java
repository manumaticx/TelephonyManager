/**
 * TelephonyManager Android Module for Titanium
 * Copyright (c) 2015 by GOYYA Systems GmbH & Co.KG
 */
package com.goyya.telephonymanager;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import android.os.Build;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.PhoneStateListener;

@Kroll.module(name="TelephonyManager", id="com.goyya.telephonymanager")
public class TelephonyManagerModule extends KrollModule
{

	private static final String LCAT = "TelephonyManagerModule";
	private static final boolean DBG = TiConfig.LOGD;
	private static TelephonyManager tm;
	private PhoneStateListener psl;
	
	// constants
	@Kroll.constant public static final int CALL_STATE_RINGING = TelephonyManager.CALL_STATE_RINGING;
	@Kroll.constant public static final int CALL_STATE_OFFHOOK = TelephonyManager.CALL_STATE_OFFHOOK;
	@Kroll.constant public static final int CALL_STATE_IDLE = TelephonyManager.CALL_STATE_IDLE;
	
	@Kroll.constant public static final int DATA_ACTIVITY_NONE = TelephonyManager.DATA_ACTIVITY_NONE;
	@Kroll.constant public static final int DATA_ACTIVITY_IN = TelephonyManager.DATA_ACTIVITY_IN;
	@Kroll.constant public static final int DATA_ACTIVITY_OUT = TelephonyManager.DATA_ACTIVITY_OUT;
	@Kroll.constant public static final int DATA_ACTIVITY_INOUT = TelephonyManager.DATA_ACTIVITY_INOUT;
	@Kroll.constant public static final int DATA_ACTIVITY_DORMANT = TelephonyManager.DATA_ACTIVITY_DORMANT;
	
	@Kroll.constant public static final int PHONE_TYPE_NONE = TelephonyManager.PHONE_TYPE_NONE;
	@Kroll.constant public static final int PHONE_TYPE_GSM = TelephonyManager.PHONE_TYPE_GSM;
	@Kroll.constant public static final int PHONE_TYPE_CDMA = TelephonyManager.PHONE_TYPE_CDMA;
	@Kroll.constant public static final int PHONE_TYPE_SIP = TelephonyManager.PHONE_TYPE_SIP;
	
	@Kroll.constant public static final int SIM_STATE_UNKNOWN = TelephonyManager.SIM_STATE_UNKNOWN;
	@Kroll.constant public static final int SIM_STATE_ABSENT = TelephonyManager.SIM_STATE_ABSENT;
	@Kroll.constant public static final int SIM_STATE_PIN_REQUIRED = TelephonyManager.SIM_STATE_PIN_REQUIRED;
	@Kroll.constant public static final int SIM_STATE_PUK_REQUIRED = TelephonyManager.SIM_STATE_PUK_REQUIRED;
	@Kroll.constant public static final int SIM_STATE_NETWORK_LOCKED = TelephonyManager.SIM_STATE_NETWORK_LOCKED;
	@Kroll.constant public static final int SIM_STATE_READY = TelephonyManager.SIM_STATE_READY;
	//@Kroll.constant public static final int SIM_STATE_NOT_READY = TelephonyManager.SIM_STATE_NOT_READY;
	//@Kroll.constant public static final int SIM_STATE_PERM_DISABLED = TelephonyManager.SIM_STATE_PERM_DISABLED;
	//@Kroll.constant public static final int SIM_STATE_CARD_IO_ERROR = TelephonyManager.SIM_STATE_CARD_IO_ERROR;

	public TelephonyManagerModule(){
		super();
	}
	
	private TelephonyManager getManager(){
		if (tm != null){
			return tm;
		}
		
		tm = (TelephonyManager) TiApplication.getAppRootOrCurrentActivity().getSystemService(Context.TELEPHONY_SERVICE);
		return tm;
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app){
		
	}
	
	@Kroll.method
	@Kroll.getProperty
	public int getCallState(){
		return getManager().getCallState();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public int getDataActivity(){
		return getManager().getDataActivity();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public int getDataState(){
		return getManager().getDataState();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getDeviceId(){
		return getManager().getDeviceId();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getDeviceSoftwareVersion(){
		return getManager().getDeviceSoftwareVersion();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getGroupIdLevel1(){
		return getManager().getGroupIdLevel1();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getLine1Number(){
		return getManager().getLine1Number();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getMmsUAProfUrl(){
		return getManager().getMmsUAProfUrl();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getMmsUserAgent(){
		return getManager().getMmsUserAgent();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getNetworkCountryIso(){
		return getManager().getNetworkCountryIso();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getNetworkOperator(){
		return getManager().getNetworkOperator();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getNetworkOperatorName(){
		return getManager().getNetworkOperatorName();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public int getNetworkType(){
		return getManager().getNetworkType();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public int getPhoneType(){
		return getManager().getPhoneType();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getSimCountryIso(){
		return getManager().getSimCountryIso();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getSimOperator(){
		return getManager().getSimOperator();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getSimOperatorName(){
		return getManager().getSimOperatorName();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getSimSerialNumber(){
		return getManager().getSimSerialNumber();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public int getSimState(){
		return getManager().getSimState();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getSubscriberId(){
		return getManager().getSubscriberId();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getVoiceMailAlphaTag(){
		return getManager().getVoiceMailAlphaTag();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String getVoiceMailNumber(){
		return getManager().getVoiceMailNumber();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public boolean getHasCarrierPrivileges(){
		if (Build.VERSION.SDK_INT >= 22){
			return getManager().hasCarrierPrivileges();
		}else{
			return false;
		}
	}
	
	@Kroll.method
	@Kroll.getProperty
	public boolean getHasIccCard(){
		return getManager().hasIccCard();
	}
	
	@Kroll.method
		public boolean iccCloseLogicalChannel(int channel){
		return getManager().iccCloseLogicalChannel(channel);
	}
	
	@Kroll.method
	@Kroll.getProperty
	public boolean getIsNetworkRoaming(){
		return getManager().isNetworkRoaming();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public boolean getIsSmsCapable(){
		return getManager().isSmsCapable();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public boolean getIsVoiceCapable(){
		return getManager().isVoiceCapable();
	}
	
	@Kroll.method
	public String sendEnvelopeWithStatus(String content){
		return getManager().sendEnvelopeWithStatus(content);
	}
	
	@Kroll.method
	public boolean setLine1NumberForDisplay(String alphaTag, String number){
		return getManager().setLine1NumberForDisplay(alphaTag, number);
	}
	
	@Kroll.method
	public boolean setOperatorBrandOverride(String brand){
		return getManager().setOperatorBrandOverride(brand);
	}
	
	@Kroll.method
	public boolean setPreferredNetworkTypeToGlobal(){
		return getManager().setPreferredNetworkTypeToGlobal();
	}
	
	@Kroll.setProperty
	public boolean setVoiceMailNumber(String alphaTag, String number){
		return getManager().setVoiceMailNumber(alphaTag, number);
	}
	
}
