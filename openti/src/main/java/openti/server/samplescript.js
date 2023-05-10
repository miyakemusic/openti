var MT1041A = 'MT1041A';
var imag2 = '<img  width="250" height="180" src="https://docs.oracle.com/cd/E65867_01/html/E65869/figures/128469.jpg" />';
var imag = '<img width="250" height="180" src="https://dl.cdn-anritsu.com/images/tm/news/ja-jp/20181203-mt1000a-front-j.jpg?h=271&w=420" />';
var controls = '{"controls":[{"type":"Button","title":"OTDR","id":"otdr"},{"type":"Button","title":"Inspection Probe","id":"vip"},{"type":"Button","title":"Power Meter","id":"opm"}]}';

for (var i = 0; i < 3; i++) {
var reply = sb.message(MT1041A, '<div><b>Connect SFP with following procedure.</b></div><div>FIBER NUMBER:<font weight="bold" color="red"> ' + i + '</fond></div>' + imag2 + imag, controls);
if (reply == 'otdr') {
 sb.write(MT1041A, 'ID_APPLICATION=ID_APPLICATION_OTDR');  
 sb.sleep(1508);
 sb.write(MT1041A, 'ID_OTDR_TESTCONTROL=ID_OTDR_TESTCONTROL_START');
 sb.sleep(2812);
}
else if (reply == 'vip') {
 sb.write(MT1041A, 'ID_APPLICATION=ID_APPLICATION_VIP');
 sb.sleep(1343);
 sb.write(MT1041A, 'ID_VIPCONTROL=ID_VIPCONTROL_START');
}
else if (reply == 'opm') {
 sb.write(MT1041A, 'ID_APPLICATION=ID_APPLICATION_OLTS');
 sb.sleep(1336);
 sb.write(MT1041A, 'ID_LS_ENABLED=ID_LS_ENABLED_ON');
 sb.sleep(1641);
 sb.write(MT1041A, 'ID_LS_ENABLED=ID_LS_ENABLED_OFF');
}
}

var controls2 = '{"controls":[{"type":"Button","title":"OK","id":"ok"}]}';

sb.message(MT1041A, '<h1>Good Job! <br>You can go home now!</h1>', controls2 );