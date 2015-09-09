var telephonymanager = require('com.goyya.telephonymanager');

telephonymanager.addEventListener('callState', function(e){
  console.log('callState changed to: ' + e.state
            + '\nincomingNumber: ' + e.incomingNumber);
  // e.state is on of: 
  // - telephonymanager.CALL_STATE_RINGING
  // - telephonymanager.CALL_STATE_OFFHOOK
  // - telephonymanager.CALL_STATE_IDLE
});

console.log('callState:             ' + telephonymanager.callState);
console.log('dataActivity:          ' + telephonymanager.dataActivity);
console.log('dataState:             ' + telephonymanager.dataState);
console.log('deviceId:              ' + telephonymanager.deviceId);
console.log('deviceSoftwareVersion: ' + telephonymanager.deviceSoftwareVersion);
console.log('groupIdLevel1:         ' + telephonymanager.groupIdLevel1);
console.log('line1Number:           ' + telephonymanager.line1Number);
console.log('mmsUAProfUrl:          ' + telephonymanager.mmsUAProfUrl);
console.log('mmsUserAgent:          ' + telephonymanager.mmsUserAgent);
console.log('networkCountryIso:     ' + telephonymanager.networkCountryIso);
console.log('networkOperator:       ' + telephonymanager.networkOperator);
console.log('networkOperatorName:   ' + telephonymanager.networkOperatorName);
console.log('networkType:           ' + telephonymanager.networkType);
console.log('phoneType:             ' + telephonymanager.phoneType);
console.log('simCountryIso:         ' + telephonymanager.simCountryIso);
console.log('simOperator:           ' + telephonymanager.simOperator);
console.log('simOperatorName:       ' + telephonymanager.simOperatorName);
console.log('simSerialNumber:       ' + telephonymanager.simSerialNumber);
console.log('simState:              ' + telephonymanager.simState);
console.log('subscriberId:          ' + telephonymanager.subscriberId);
console.log('voiceMailAlphaTag:     ' + telephonymanager.voiceMailAlphaTag);
console.log('voiceMailNumber:       ' + telephonymanager.voiceMailNumber);
console.log('hasCarrierPrivileges:  ' + telephonymanager.hasCarrierPrivileges);
console.log('hasIccCard:            ' + telephonymanager.hasIccCard);
console.log('isNetworkRoaming:      ' + telephonymanager.isNetworkRoaming);
console.log('isSmsCapable:          ' + telephonymanager.isSmsCapable);
console.log('isVoiceCapable:        ' + telephonymanager.isVoiceCapable);