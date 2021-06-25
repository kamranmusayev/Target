package com.target.objects;

public enum Images {
	MAP1("/com/target/assets/map1.png"),
	MAP2("/com/target/assets/map2.png"),
	MAP3("/com/target/assets/map3.png"),
	BOW1("/com/target/assets/bow1.png"),
	ARROW1("/com/target/assets/arrow1.png"),
	OBSTACLE1("/com/target/assets/obstacle1.png"),
	GOAL1("/com/target/assets/target1.png"),
	MAINMENU("/com/target/assets/mainmenu.jpg"),
	PAUSEMENU("/com/target/assets/pausemenu.png"),
	SETTINGSMENU("/com/target/assets/settingsmenu.png"),
	LEVELMENU("/com/target/assets/levelmenu.png"),
	SHOPMENU("/com/target/assets/shopmenu.png"),
	CONSOLEMENU("/com/target/assets/consolemenu.png"),
	COSTUMEMENU1("/com/target/assets/costume1.png"),
	COSTUMEMENU2("/com/target/assets/costume2.png"),
	SETTINGS("/com/target/assets/settings.png"),
	TIK("/com/target/assets/tik.png"),
	SES("/com/target/assets/ses.png"),
	PARA("/com/target/assets/para.png"),
	OK1("/com/target/assets/ok_1.png"),
	OK2("/com/target/assets/ok_2.png"),
	OK3("/com/target/assets/ok_3.png"),
	OK4("/com/target/assets/ok_4.png"),
	OK5("/com/target/assets/ok_5.png"),
	OK6("/com/target/assets/ok_6.png"),
	OK7("/com/target/assets/ok_7.png"),
	OK8("/com/target/assets/ok_8.png"),
	YAY1("/com/target/assets/yay1.png"),
	YAY2("/com/target/assets/yay2.png"),
	YAY3("/com/target/assets/yay3.png"),
	YAY4("/com/target/assets/yay4.png"),
	ARMUT("/com/target/assets/armut.png"),
	ELMA("/com/target/assets/elma.png"),
	KARPUZ("/com/target/assets/karpuz.png"),
	PORTAKAL("/com/target/assets/portakal.png"),
	BACKGROUND("/com/target/assets/back.jpg"),
	USERNAME("/com/target/assets/username.png"),
	PASSWORD("/com/target/assets/password.png"),
	LOGIN("/com/target/assets/login.png"),
	REGISTER("/com/target/assets/register.png"),
	OBSTACLE2("/com/target/assets/obstacle2.png"),
	OBSTACLE3("/com/target/assets/obstacle3.png"),
	OBSTACLE4("/com/target/assets/obstacle4.png"),
	OBSTACLE5("/com/target/assets/obstacle5.png"),
	OBSTACLE6("/com/target/assets/obstacle6.png"),
	GOAL2("/com/target/assets/target2.png"),
	GOAL3("/com/target/assets/target3.png"),
	GOAL4("/com/target/assets/target4.png"),
	MAP4("/com/target/assets/map4.png"),
	MAP5("/com/target/assets/map5.png");
	
	public String string;
	
	Images(String string) {
		this.string=string;
	}
	
	public String getString() {
		return string;
	}
}
