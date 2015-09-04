# Titanium TelephonyManager [![gittio](http://img.shields.io/badge/gittio-1.0.0-00B4CC.svg)](http://gitt.io/component/com.goyya.telephonymanager)
> Titanium Module for accessing the Android TelephonyManager

## Description

This module exposes the Android [TelephonyManager](http://developer.android.com/reference/android/telephony/TelephonyManager.html) to Titanium.

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

NOTE: This module automatically adds the `READ_PHONE_STATE` permission to your manifest. If you are using methods of the TelephonyManager that are requiring any other permission, please add it manually to your tiapp.xml
---

## License

[The MIT License (MIT)](LICENSE)