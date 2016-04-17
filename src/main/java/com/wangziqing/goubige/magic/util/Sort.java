package com.wangziqing.goubige.magic.util;

public interface Sort {
	public enum nvZhuang implements Sort{
		YRMF("羽绒棉服","1236004"),BDKZ("百搭裤子","1072001"),WTDY("外套大衣","1236003"),
		MYKS("毛衣开衫","1034001"),XPMQ("新品美裙","1070002"),PCPY("皮草皮衣","1236005"),
		CSFY("衬衫风衣","1026004"),WYRY("卫衣绒衣","1070005"),MMZ("妈妈装","1010166"),
		DMZ("大码装","1010170");
		private String value,ID;
		private nvZhuang(String value,String ID){
			this.ID=ID;
			this.value=value;
		}
		@Override
		public String getBlockValue() {
			// TODO Auto-generated method stub
			return "女装";
		}

		@Override
		public String getBlockID() {
			// TODO Auto-generated method stub
			return "901";
		}
		public String getTagValue(){
			return value;
		}
		public String getTagID(){
			return ID;
		}
	}
	
	public enum neiYi implements Sort{
		BNTZ("保暖套装","1010102"),JJTZ("居家套装","1010103"),NSNY("女士内衣","1010104"),
		NK("内裤","1010105"),SSTZ("塑身套装","1010106");
		private String value,ID;
		private neiYi(String value,String ID){
			this.ID=ID;
			this.value=value;
		}
		@Override
		public String getBlockValue() {
			// TODO Auto-generated method stub
			return "内衣";
		}

		@Override
		public String getBlockID() {
			// TODO Auto-generated method stub
			return "902";
		}
		public String getTagValue(){
			return value;
		}
		public String getTagID(){
			return ID;
		}
	}
	
	public enum baoBaoPetShi implements Sort{
		SB("手表","1098001"),TYYJ("太阳眼镜","1096001"),NB("女包","1010127"),
		SJB("双肩包","1010135"),LGX("拉杆箱","1010142"),NSBD("男士包袋","1010149"),
		WJ("围巾","1010155"),MZST("帽子手套","1010160"),PD("皮带","1010165"),
		SP("饰品","1010169");
		private String value,ID;
		private baoBaoPetShi(String value,String ID){
			this.ID=ID;
			this.value=value;
		}
		@Override
		public String getBlockValue() {
			// TODO Auto-generated method stub
			return "包包配饰";
		}

		@Override
		public String getBlockID() {
			// TODO Auto-generated method stub
			return "903";
		}
		public String getTagValue(){
			return value;
		}
		public String getTagID(){
			return ID;
		}
	}
	
	public enum nanXieNvXie implements Sort{
		NV("男鞋","1010134"),NAN("女鞋","1010128");
		private String value,ID;
		private nanXieNvXie(String value,String ID){
			this.ID=ID;
			this.value=value;
		}
		@Override
		public String getBlockValue() {
			// TODO Auto-generated method stub
			return "男鞋女鞋";
		}

		@Override
		public String getBlockID() {
			// TODO Auto-generated method stub
			return "904";
		}
		public String getTagValue(){
			return value;
		}
		public String getTagID(){
			return ID;
		}
	}
	
	public enum nanZhuang implements Sort{
		YRF("羽绒服","1204002"),NZK("牛仔裤","1010174"),MNDY("毛呢大衣","1204001"),
		MY("毛衣","1206002"),PY("皮衣","1204005"),FY("风衣","1206003"),
		CS("衬衫","1010164"),WY("卫衣","1204003"),XXK("休闲裤","1010172"),
		TX("T恤","1038004"),JK("夹克","1204004"),ZZS("针织衫","1206001");
		private String value,ID;
		private nanZhuang(String value,String ID){
			this.ID=ID;
			this.value=value;
		}
		@Override
		public String getBlockValue() {
			// TODO Auto-generated method stub
			return "男装";
		}

		@Override
		public String getBlockID() {
			// TODO Auto-generated method stub
			return "905";
		}
		public String getTagValue(){
			return value;
		}
		public String getTagID(){
			return ID;
		}
	}

	public enum youEr implements Sort{
		TZ("童装","1038002"),TX("童鞋","1122001"),WJ("玩具","1120001"),
		BB("宝宝","1228001"),YC("孕产用品","1010171"),NF("奶粉尿片","1124001");
		private String value,ID;
		private youEr(String value,String ID){
			this.ID=ID;
			this.value=value;
		}
		@Override
		public String getBlockValue() {
			// TODO Auto-generated method stub
			return "幼儿";
		}

		@Override
		public String getBlockID() {
			// TODO Auto-generated method stub
			return "906";
		}
		public String getTagValue(){
			return value;
		}
		public String getTagID(){
			return ID;
		}
	}
	
	public enum riYongBaiHuo implements Sort{
		CSYP("床上用品","1036008"),JJSP("家居饰品","1036010"),JJBY("居家布艺","1038005"),
		JZJC("家装建材","1038010"),SHRY("生活日用","1038007"),CYCJ("餐饮厨具","1038009"),
		QJSN("清洁收纳","1038008");
		private String value,ID;
		private riYongBaiHuo(String value,String ID){
			this.ID=ID;
			this.value=value;
		}
		@Override
		public String getBlockValue() {
			// TODO Auto-generated method stub
			return "日用百货";
		}

		@Override
		public String getBlockID() {
			// TODO Auto-generated method stub
			return "907";
		}
		public String getTagValue(){
			return value;
		}
		public String getTagID(){
			return ID;
		}
	}

	public enum meiShiTeChan implements Sort{
		LSTC("零食特产","1010091"),ZBYYP("滋补营养品","1010092"),LYMM("粮油米面","1010093"),
		CYJL("冲饮酒类","1010094");
		private String value,ID;
		private meiShiTeChan(String value,String ID){
			this.ID=ID;
			this.value=value;
		}
		@Override
		public String getBlockValue() {
			// TODO Auto-generated method stub
			return "美食特产";
		}

		@Override
		public String getBlockID() {
			// TODO Auto-generated method stub
			return "908";
		}
		public String getTagValue(){
			return value;
		}
		public String getTagID(){
			return ID;
		}
	}

	public enum shuMaJiaDian implements Sort{
		SHDQ("生活电器","1010095"),CFDQ("厨房电器","1010097"),JTDQ("家庭电器","1010098"),
		SMPJ("数码配件","1010100"),HLBJ("护理保健","1010101");
		private String value,ID;
		private shuMaJiaDian(String value,String ID){
			this.ID=ID;
			this.value=value;
		}
		@Override
		public String getBlockValue() {
			// TODO Auto-generated method stub
			return "数码家电";
		}

		@Override
		public String getBlockID() {
			// TODO Auto-generated method stub
			return "909";
		}
		public String getTagValue(){
			return value;
		}
		public String getTagID(){
			return ID;
		}
	}

	public enum meiRongHuFu implements Sort{
		MM("面膜","1010129"),JMSF("洁面爽肤","1010136"),TZ("套装","1010143"),
		RYJH("乳液精华","1010150"),BCYY("补充营养","1010156"),CZJY("彩妆精油","1010161");
		private String value,ID;
		private meiRongHuFu(String value,String ID){
			this.ID=ID;
			this.value=value;
		}
		@Override
		public String getBlockValue() {
			// TODO Auto-generated method stub
			return "美容护肤";
		}

		@Override
		public String getBlockID() {
			// TODO Auto-generated method stub
			return "910";
		}
		public String getTagValue(){
			return value;
		}
		public String getTagID(){
			return ID;
		}
	}

	public enum chePinHuWai implements Sort{
		HWLX("户外旅行","1010107"),YDJS("运动健身","1010109"),QCYP("汽车用品","1010111");
		private String value,ID;
		private chePinHuWai(String value,String ID){
			this.ID=ID;
			this.value=value;
		}
		@Override
		public String getBlockValue() {
			// TODO Auto-generated method stub
			return "车品户外";
		}

		@Override
		public String getBlockID() {
			// TODO Auto-generated method stub
			return "911";
		}
		public String getTagValue(){
			return value;
		}
		public String getTagID(){
			return ID;
		}
	}

	public String getBlockValue();
	public String getBlockID();
}
