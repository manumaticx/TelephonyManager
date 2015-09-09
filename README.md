# Titanium TelephonyManager [![gittio](http://img.shields.io/badge/gittio-1.0.0-00B4CC.svg)](http://gitt.io/component/com.goyya.telephonymanager)
> Titanium Module for accessing the Android TelephonyManager

## Description

This module exposes the Android [TelephonyManager](http://developer.android.com/reference/android/telephony/TelephonyManager.html) to Titanium.

(If you are looking for something similar for iOS you should check out David Bankier's [CoreTelephony ](https://github.com/dbankier/CoreTelephony-for-Appcelerator-Titanium) module)

## Quick Start

### Installation 
Download the latest distribution ZIP-file and consult the [Titanium Documentation](http://docs.appcelerator.com/titanium/latest/#!/guide/Using_a_Module) on how install it, or simply use the [gitTio CLI](http://gitt.io/cli):

`$ gittio install com.goyya.telephonymanager`

### Usage

For the full API documentation please see [here](http://developer.android.com/reference/android/telephony/TelephonyManager.html)

```javascript
var telephonymanager = require("com.goyya.telephonymanager");

// these are just some infos you can get
console.log('callState:             ' + telephonymanager.callState);
console.log('deviceId:              ' + telephonymanager.deviceId);
console.log('deviceSoftwareVersion: ' + telephonymanager.deviceSoftwareVersion);
console.log('phoneNumber:           ' + telephonymanager.line1Number);
console.log('networkOperator:       ' + telephonymanager.networkOperator);
console.log('networkOperatorName:   ' + telephonymanager.networkOperatorName);
console.log('networkType:           ' + telephonymanager.networkType);
console.log('phoneType:             ' + telephonymanager.phoneType);
console.log('simOperator:           ' + telephonymanager.simOperator);
console.log('simOperatorName:       ' + telephonymanager.simOperatorName);
console.log('simSerialNumber:       ' + telephonymanager.simSerialNumber);
console.log('simState:              ' + telephonymanager.simState);
console.log('voiceMailNumber:       ' + telephonymanager.voiceMailNumber);
console.log('isNetworkRoaming:      ' + telephonymanager.isNetworkRoaming);
console.log('isSmsCapable:          ' + telephonymanager.isSmsCapable);
console.log('isVoiceCapable:        ' + telephonymanager.isVoiceCapable);
```

> NOTE: This module automatically adds the `READ_PHONE_STATE` permission to your manifest. If you are using methods of the TelephonyManager that are requiring any other permission, please add it manually to your tiapp.xml

## API Documentation

### Properties

* `callState` _(Number)_
  * `CALL_STATE_RINGING`
  * `CALL_STATE_OFFHOOK`
  * `CALL_STATE_IDLE`
* `dataActivity` _(Number)_
  * `DATA_ACTIVITY_NONE`
  * `DATA_ACTIVITY_IN`
  * `DATA_ACTIVITY_OUT`
  * `DATA_ACTIVITY_INOUT`
  * `DATA_ACTIVITY_DORMANT`
* `dataState` _(Number)_
  * `DATA_DISCONNECTED`
  * `DATA_CONNECTING`
  * `DATA_CONNECTED`
  * `DATA_SUSPENDED`
* `deviceId` _(String)_
* `deviceSoftwareVersion` _(String)_
* `groupIdLevel1` _(String)_
* `line1Number` _(String)_
* `mmsUAProfUrl` _(String)_
* `mmsUserAgent` _(String)_
* `networkCountryIso` _(String)_
* `networkOperator` _(String)_
* `networkOperatorName` _(String)_
* `networkType` _(Number)_
  * `NETWORK_TYPE_1xRTT`
  * `NETWORK_TYPE_CDMA`
  * `NETWORK_TYPE_EDGE`
  * `NETWORK_TYPE_EHRPD`
  * `NETWORK_TYPE_EVDO_0`
  * `NETWORK_TYPE_EVDO_A`
  * `NETWORK_TYPE_EVDO_B`
  * `NETWORK_TYPE_GPRS`
  * `NETWORK_TYPE_HSDPA`
  * `NETWORK_TYPE_HSPA`
  * `NETWORK_TYPE_HSPAP`
  * `NETWORK_TYPE_HSUPA`
  * `NETWORK_TYPE_IDEN`
  * `NETWORK_TYPE_LTE`
  * `NETWORK_TYPE_UMTS`
  * `NETWORK_TYPE_UNKNOWN`
* `phoneType` _(Number)_
  * `PHONE_TYPE_NONE`
  * `PHONE_TYPE_GSM`
  * `PHONE_TYPE_CDMA`
  * `PHONE_TYPE_SIP`
* `simCountryIso` _(String)_
* `simOperator` _(String)_
* `simOperatorName` _(String)_
* `simSerialNumber` _(String)_
* `simState` _(Number)_
  * `SIM_STATE_UNKNOWN`
  * `SIM_STATE_ABSENT`
  * `SIM_STATE_PIN_REQUIRED`
  * `SIM_STATE_PUK_REQUIRED`
  * `SIM_STATE_NETWORK_LOCKED`
  * `SIM_STATE_READY`
* `subscriberId` _(String)_
* `voiceMailAlphaTag` _(String)_
* `voiceMailNumber` _(String)_
* `hasCarrierPrivileges` _(Boolean)_
* `hasIccCard` _(Boolean)_
* `isNetworkRoaming` _(Boolean)_
* `isSmsCapable` _(Boolean)_
* `isVoiceCapable` _(Boolean)_


### Events

* `callForwardingIndicator`
* `callState` 
* `cellInfo`
* `cellLocation`
* `dataActivity`
* `dataConnectionState`
* `messageWaitingIndicator`
* `serviceState`
* `signalStrengths`

## License

[The MIT License (MIT)](LICENSE)
