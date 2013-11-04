package trading.app.adapter.plaza2.scheme;

public final class FortsMessages
{


// ------------------------------------------
// Scheme "message"
// ------------------------------------------

    public static final class FutAddOrder
    {
        public static final int TABLE_INDEX = 0;
        public static final int MSG_ID = 36;
	public static final int MSG_SIZE = 146;
        private java.nio.ByteBuffer data;

        public FutAddOrder() {
            
        }

        public FutAddOrder(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public String get_isin() {
            data.position(5);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(5);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_client_code() {
            data.position(31);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 3);
        }

        public void set_client_code(String val) {
            data.position(31);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 3);
        }

        
    
        public int get_type() {
            data.position(36);
            return data.getInt();
        }

        public void set_type(int val) {
            data.position(36);
            data.putInt(val);
        }

        
    
        public int get_dir() {
            data.position(40);
            return data.getInt();
        }

        public void set_dir(int val) {
            data.position(40);
            data.putInt(val);
        }

        
    
        public int get_amount() {
            data.position(44);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(44);
            data.putInt(val);
        }

        
    
        public String get_price() {
            data.position(48);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_price(String val) {
            data.position(48);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public String get_comment() {
            data.position(66);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_comment(String val) {
            data.position(66);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public String get_broker_to() {
            data.position(87);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_broker_to(String val) {
            data.position(87);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public int get_ext_id() {
            data.position(108);
            return data.getInt();
        }

        public void set_ext_id(int val) {
            data.position(108);
            data.putInt(val);
        }

        
    
        public int get_du() {
            data.position(112);
            return data.getInt();
        }

        public void set_du(int val) {
            data.position(112);
            data.putInt(val);
        }

        
    
        public String get_date_exp() {
            data.position(116);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 8);
        }

        public void set_date_exp(String val) {
            data.position(116);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 8);
        }

        
    
        public int get_hedge() {
            data.position(128);
            return data.getInt();
        }

        public void set_hedge(int val) {
            data.position(128);
            data.putInt(val);
        }

        
    
        public int get_dont_check_money() {
            data.position(132);
            return data.getInt();
        }

        public void set_dont_check_money(int val) {
            data.position(132);
            data.putInt(val);
        }

        
    
        public java.util.Date get_local_stamp() {
            data.position(136);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_local_stamp(java.util.Date val) {
            data.position(136);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class FORTS_MSG101
    {
        public static final int TABLE_INDEX = 1;
        public static final int MSG_ID = 101;
	public static final int MSG_SIZE = 268;
        private java.nio.ByteBuffer data;

        public FORTS_MSG101() {
            
        }

        public FORTS_MSG101(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    
        public long get_order_id() {
            data.position(260);
            return data.getLong();
        }

        public void set_order_id(long val) {
            data.position(260);
            data.putLong(val);
        }

        
    


    }

    public static final class FutAddMultiLegOrder
    {
        public static final int TABLE_INDEX = 2;
        public static final int MSG_ID = 40;
	public static final int MSG_SIZE = 158;
        private java.nio.ByteBuffer data;

        public FutAddMultiLegOrder() {
            
        }

        public FutAddMultiLegOrder(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_sess_id() {
            data.position(8);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public int get_isin_id() {
            data.position(12);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(12);
            data.putInt(val);
        }

        
    
        public String get_client_code() {
            data.position(16);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 3);
        }

        public void set_client_code(String val) {
            data.position(16);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 3);
        }

        
    
        public int get_type() {
            data.position(20);
            return data.getInt();
        }

        public void set_type(int val) {
            data.position(20);
            data.putInt(val);
        }

        
    
        public int get_dir() {
            data.position(24);
            return data.getInt();
        }

        public void set_dir(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public int get_amount() {
            data.position(28);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(28);
            data.putInt(val);
        }

        
    
        public String get_price() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_price(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public String get_rate_price() {
            data.position(50);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_rate_price(String val) {
            data.position(50);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public String get_comment() {
            data.position(68);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_comment(String val) {
            data.position(68);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public int get_hedge() {
            data.position(92);
            return data.getInt();
        }

        public void set_hedge(int val) {
            data.position(92);
            data.putInt(val);
        }

        
    
        public String get_broker_to() {
            data.position(96);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_broker_to(String val) {
            data.position(96);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public int get_ext_id() {
            data.position(120);
            return data.getInt();
        }

        public void set_ext_id(int val) {
            data.position(120);
            data.putInt(val);
        }

        
    
        public int get_trust() {
            data.position(124);
            return data.getInt();
        }

        public void set_trust(int val) {
            data.position(124);
            data.putInt(val);
        }

        
    
        public String get_date_exp() {
            data.position(128);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 8);
        }

        public void set_date_exp(String val) {
            data.position(128);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 8);
        }

        
    
        public int get_trade_mode() {
            data.position(140);
            return data.getInt();
        }

        public void set_trade_mode(int val) {
            data.position(140);
            data.putInt(val);
        }

        
    
        public int get_dont_check_money() {
            data.position(144);
            return data.getInt();
        }

        public void set_dont_check_money(int val) {
            data.position(144);
            data.putInt(val);
        }

        
    
        public java.util.Date get_local_stamp() {
            data.position(148);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_local_stamp(java.util.Date val) {
            data.position(148);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class FORTS_MSG129
    {
        public static final int TABLE_INDEX = 3;
        public static final int MSG_ID = 129;
	public static final int MSG_SIZE = 268;
        private java.nio.ByteBuffer data;

        public FORTS_MSG129() {
            
        }

        public FORTS_MSG129(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    
        public long get_order_id() {
            data.position(260);
            return data.getLong();
        }

        public void set_order_id(long val) {
            data.position(260);
            data.putLong(val);
        }

        
    


    }

    public static final class FutDelOrder
    {
        public static final int TABLE_INDEX = 4;
        public static final int MSG_ID = 37;
	public static final int MSG_SIZE = 26;
        private java.nio.ByteBuffer data;

        public FutDelOrder() {
            
        }

        public FutDelOrder(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public long get_order_id() {
            data.position(8);
            return data.getLong();
        }

        public void set_order_id(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public java.util.Date get_local_stamp() {
            data.position(16);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_local_stamp(java.util.Date val) {
            data.position(16);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class FORTS_MSG102
    {
        public static final int TABLE_INDEX = 5;
        public static final int MSG_ID = 102;
	public static final int MSG_SIZE = 264;
        private java.nio.ByteBuffer data;

        public FORTS_MSG102() {
            
        }

        public FORTS_MSG102(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    
        public int get_amount() {
            data.position(260);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(260);
            data.putInt(val);
        }

        
    


    }

    public static final class FutDelUserOrders
    {
        public static final int TABLE_INDEX = 6;
        public static final int MSG_ID = 38;
	public static final int MSG_SIZE = 92;
        private java.nio.ByteBuffer data;

        public FutDelUserOrders() {
            
        }

        public FutDelUserOrders(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_buy_sell() {
            data.position(8);
            return data.getInt();
        }

        public void set_buy_sell(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public int get_non_system() {
            data.position(12);
            return data.getInt();
        }

        public void set_non_system(int val) {
            data.position(12);
            data.putInt(val);
        }

        
    
        public String get_code() {
            data.position(16);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 3);
        }

        public void set_code(String val) {
            data.position(16);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 3);
        }

        
    
        public String get_code_vcb() {
            data.position(20);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(20);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public int get_ext_id() {
            data.position(48);
            return data.getInt();
        }

        public void set_ext_id(int val) {
            data.position(48);
            data.putInt(val);
        }

        
    
        public int get_work_mode() {
            data.position(52);
            return data.getInt();
        }

        public void set_work_mode(int val) {
            data.position(52);
            data.putInt(val);
        }

        
    
        public String get_isin() {
            data.position(56);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(56);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public java.util.Date get_local_stamp() {
            data.position(82);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_local_stamp(java.util.Date val) {
            data.position(82);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class FORTS_MSG103
    {
        public static final int TABLE_INDEX = 7;
        public static final int MSG_ID = 103;
	public static final int MSG_SIZE = 264;
        private java.nio.ByteBuffer data;

        public FORTS_MSG103() {
            
        }

        public FORTS_MSG103(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    
        public int get_num_orders() {
            data.position(260);
            return data.getInt();
        }

        public void set_num_orders(int val) {
            data.position(260);
            data.putInt(val);
        }

        
    


    }

    public static final class FutMoveOrder
    {
        public static final int TABLE_INDEX = 8;
        public static final int MSG_ID = 39;
	public static final int MSG_SIZE = 94;
        private java.nio.ByteBuffer data;

        public FutMoveOrder() {
            
        }

        public FutMoveOrder(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_regime() {
            data.position(8);
            return data.getInt();
        }

        public void set_regime(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public long get_order_id1() {
            data.position(12);
            return data.getLong();
        }

        public void set_order_id1(long val) {
            data.position(12);
            data.putLong(val);
        }

        
    
        public int get_amount1() {
            data.position(20);
            return data.getInt();
        }

        public void set_amount1(int val) {
            data.position(20);
            data.putInt(val);
        }

        
    
        public String get_price1() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_price1(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public int get_ext_id1() {
            data.position(44);
            return data.getInt();
        }

        public void set_ext_id1(int val) {
            data.position(44);
            data.putInt(val);
        }

        
    
        public long get_order_id2() {
            data.position(48);
            return data.getLong();
        }

        public void set_order_id2(long val) {
            data.position(48);
            data.putLong(val);
        }

        
    
        public int get_amount2() {
            data.position(56);
            return data.getInt();
        }

        public void set_amount2(int val) {
            data.position(56);
            data.putInt(val);
        }

        
    
        public String get_price2() {
            data.position(60);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_price2(String val) {
            data.position(60);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public int get_ext_id2() {
            data.position(80);
            return data.getInt();
        }

        public void set_ext_id2(int val) {
            data.position(80);
            data.putInt(val);
        }

        
    
        public java.util.Date get_local_stamp() {
            data.position(84);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_local_stamp(java.util.Date val) {
            data.position(84);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class FORTS_MSG105
    {
        public static final int TABLE_INDEX = 9;
        public static final int MSG_ID = 105;
	public static final int MSG_SIZE = 276;
        private java.nio.ByteBuffer data;

        public FORTS_MSG105() {
            
        }

        public FORTS_MSG105(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    
        public long get_order_id1() {
            data.position(260);
            return data.getLong();
        }

        public void set_order_id1(long val) {
            data.position(260);
            data.putLong(val);
        }

        
    
        public long get_order_id2() {
            data.position(268);
            return data.getLong();
        }

        public void set_order_id2(long val) {
            data.position(268);
            data.putLong(val);
        }

        
    


    }

    public static final class OptAddOrder
    {
        public static final int TABLE_INDEX = 10;
        public static final int MSG_ID = 41;
	public static final int MSG_SIZE = 150;
        private java.nio.ByteBuffer data;

        public OptAddOrder() {
            
        }

        public OptAddOrder(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public String get_isin() {
            data.position(5);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(5);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_client_code() {
            data.position(31);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 3);
        }

        public void set_client_code(String val) {
            data.position(31);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 3);
        }

        
    
        public int get_type() {
            data.position(36);
            return data.getInt();
        }

        public void set_type(int val) {
            data.position(36);
            data.putInt(val);
        }

        
    
        public int get_dir() {
            data.position(40);
            return data.getInt();
        }

        public void set_dir(int val) {
            data.position(40);
            data.putInt(val);
        }

        
    
        public int get_amount() {
            data.position(44);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(44);
            data.putInt(val);
        }

        
    
        public String get_price() {
            data.position(48);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_price(String val) {
            data.position(48);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public String get_comment() {
            data.position(66);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_comment(String val) {
            data.position(66);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public String get_broker_to() {
            data.position(87);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_broker_to(String val) {
            data.position(87);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public int get_ext_id() {
            data.position(108);
            return data.getInt();
        }

        public void set_ext_id(int val) {
            data.position(108);
            data.putInt(val);
        }

        
    
        public int get_du() {
            data.position(112);
            return data.getInt();
        }

        public void set_du(int val) {
            data.position(112);
            data.putInt(val);
        }

        
    
        public int get_check_limit() {
            data.position(116);
            return data.getInt();
        }

        public void set_check_limit(int val) {
            data.position(116);
            data.putInt(val);
        }

        
    
        public String get_date_exp() {
            data.position(120);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 8);
        }

        public void set_date_exp(String val) {
            data.position(120);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 8);
        }

        
    
        public int get_hedge() {
            data.position(132);
            return data.getInt();
        }

        public void set_hedge(int val) {
            data.position(132);
            data.putInt(val);
        }

        
    
        public int get_dont_check_money() {
            data.position(136);
            return data.getInt();
        }

        public void set_dont_check_money(int val) {
            data.position(136);
            data.putInt(val);
        }

        
    
        public java.util.Date get_local_stamp() {
            data.position(140);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_local_stamp(java.util.Date val) {
            data.position(140);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class FORTS_MSG109
    {
        public static final int TABLE_INDEX = 11;
        public static final int MSG_ID = 109;
	public static final int MSG_SIZE = 268;
        private java.nio.ByteBuffer data;

        public FORTS_MSG109() {
            
        }

        public FORTS_MSG109(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    
        public long get_order_id() {
            data.position(260);
            return data.getLong();
        }

        public void set_order_id(long val) {
            data.position(260);
            data.putLong(val);
        }

        
    


    }

    public static final class OptDelOrder
    {
        public static final int TABLE_INDEX = 12;
        public static final int MSG_ID = 42;
	public static final int MSG_SIZE = 26;
        private java.nio.ByteBuffer data;

        public OptDelOrder() {
            
        }

        public OptDelOrder(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public long get_order_id() {
            data.position(8);
            return data.getLong();
        }

        public void set_order_id(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public java.util.Date get_local_stamp() {
            data.position(16);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_local_stamp(java.util.Date val) {
            data.position(16);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class FORTS_MSG110
    {
        public static final int TABLE_INDEX = 13;
        public static final int MSG_ID = 110;
	public static final int MSG_SIZE = 264;
        private java.nio.ByteBuffer data;

        public FORTS_MSG110() {
            
        }

        public FORTS_MSG110(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    
        public int get_amount() {
            data.position(260);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(260);
            data.putInt(val);
        }

        
    


    }

    public static final class OptDelUserOrders
    {
        public static final int TABLE_INDEX = 14;
        public static final int MSG_ID = 43;
	public static final int MSG_SIZE = 92;
        private java.nio.ByteBuffer data;

        public OptDelUserOrders() {
            
        }

        public OptDelUserOrders(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_buy_sell() {
            data.position(8);
            return data.getInt();
        }

        public void set_buy_sell(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public int get_non_system() {
            data.position(12);
            return data.getInt();
        }

        public void set_non_system(int val) {
            data.position(12);
            data.putInt(val);
        }

        
    
        public String get_code() {
            data.position(16);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 3);
        }

        public void set_code(String val) {
            data.position(16);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 3);
        }

        
    
        public String get_code_vcb() {
            data.position(20);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(20);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public int get_ext_id() {
            data.position(48);
            return data.getInt();
        }

        public void set_ext_id(int val) {
            data.position(48);
            data.putInt(val);
        }

        
    
        public int get_work_mode() {
            data.position(52);
            return data.getInt();
        }

        public void set_work_mode(int val) {
            data.position(52);
            data.putInt(val);
        }

        
    
        public String get_isin() {
            data.position(56);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(56);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public java.util.Date get_local_stamp() {
            data.position(82);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_local_stamp(java.util.Date val) {
            data.position(82);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class FORTS_MSG111
    {
        public static final int TABLE_INDEX = 15;
        public static final int MSG_ID = 111;
	public static final int MSG_SIZE = 264;
        private java.nio.ByteBuffer data;

        public FORTS_MSG111() {
            
        }

        public FORTS_MSG111(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    
        public int get_num_orders() {
            data.position(260);
            return data.getInt();
        }

        public void set_num_orders(int val) {
            data.position(260);
            data.putInt(val);
        }

        
    


    }

    public static final class OptMoveOrder
    {
        public static final int TABLE_INDEX = 16;
        public static final int MSG_ID = 44;
	public static final int MSG_SIZE = 98;
        private java.nio.ByteBuffer data;

        public OptMoveOrder() {
            
        }

        public OptMoveOrder(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_regime() {
            data.position(8);
            return data.getInt();
        }

        public void set_regime(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public long get_order_id1() {
            data.position(12);
            return data.getLong();
        }

        public void set_order_id1(long val) {
            data.position(12);
            data.putLong(val);
        }

        
    
        public int get_amount1() {
            data.position(20);
            return data.getInt();
        }

        public void set_amount1(int val) {
            data.position(20);
            data.putInt(val);
        }

        
    
        public String get_price1() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_price1(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public int get_ext_id1() {
            data.position(44);
            return data.getInt();
        }

        public void set_ext_id1(int val) {
            data.position(44);
            data.putInt(val);
        }

        
    
        public int get_check_limit() {
            data.position(48);
            return data.getInt();
        }

        public void set_check_limit(int val) {
            data.position(48);
            data.putInt(val);
        }

        
    
        public long get_order_id2() {
            data.position(52);
            return data.getLong();
        }

        public void set_order_id2(long val) {
            data.position(52);
            data.putLong(val);
        }

        
    
        public int get_amount2() {
            data.position(60);
            return data.getInt();
        }

        public void set_amount2(int val) {
            data.position(60);
            data.putInt(val);
        }

        
    
        public String get_price2() {
            data.position(64);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_price2(String val) {
            data.position(64);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public int get_ext_id2() {
            data.position(84);
            return data.getInt();
        }

        public void set_ext_id2(int val) {
            data.position(84);
            data.putInt(val);
        }

        
    
        public java.util.Date get_local_stamp() {
            data.position(88);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_local_stamp(java.util.Date val) {
            data.position(88);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class FORTS_MSG113
    {
        public static final int TABLE_INDEX = 17;
        public static final int MSG_ID = 113;
	public static final int MSG_SIZE = 276;
        private java.nio.ByteBuffer data;

        public FORTS_MSG113() {
            
        }

        public FORTS_MSG113(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    
        public long get_order_id1() {
            data.position(260);
            return data.getLong();
        }

        public void set_order_id1(long val) {
            data.position(260);
            data.putLong(val);
        }

        
    
        public long get_order_id2() {
            data.position(268);
            return data.getLong();
        }

        public void set_order_id2(long val) {
            data.position(268);
            data.putLong(val);
        }

        
    


    }

    public static final class FutChangeClientMoney
    {
        public static final int TABLE_INDEX = 18;
        public static final int MSG_ID = 60;
	public static final int MSG_SIZE = 124;
        private java.nio.ByteBuffer data;

        public FutChangeClientMoney() {
            
        }

        public FutChangeClientMoney(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_mode() {
            data.position(8);
            return data.getInt();
        }

        public void set_mode(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public String get_code() {
            data.position(12);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 3);
        }

        public void set_code(String val) {
            data.position(12);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 3);
        }

        
    
        public String get_limit_money() {
            data.position(16);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_limit_money(String val) {
            data.position(16);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public String get_limit_pledge() {
            data.position(34);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_limit_pledge(String val) {
            data.position(34);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public String get_coeff_liquidity() {
            data.position(52);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_coeff_liquidity(String val) {
            data.position(52);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public String get_coeff_go() {
            data.position(70);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_coeff_go(String val) {
            data.position(70);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public int get_is_auto_update_limit() {
            data.position(88);
            return data.getInt();
        }

        public void set_is_auto_update_limit(int val) {
            data.position(88);
            data.putInt(val);
        }

        
    
        public int get_is_auto_update_spot_limit() {
            data.position(92);
            return data.getInt();
        }

        public void set_is_auto_update_spot_limit(int val) {
            data.position(92);
            data.putInt(val);
        }

        
    
        public String get_limit_spot_buy() {
            data.position(96);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_limit_spot_buy(String val) {
            data.position(96);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public int get_no_fut_discount() {
            data.position(116);
            return data.getInt();
        }

        public void set_no_fut_discount(int val) {
            data.position(116);
            data.putInt(val);
        }

        
    
        public int get_check_limit() {
            data.position(120);
            return data.getInt();
        }

        public void set_check_limit(int val) {
            data.position(120);
            data.putInt(val);
        }

        
    


    }

    public static final class FORTS_MSG104
    {
        public static final int TABLE_INDEX = 19;
        public static final int MSG_ID = 104;
	public static final int MSG_SIZE = 260;
        private java.nio.ByteBuffer data;

        public FORTS_MSG104() {
            
        }

        public FORTS_MSG104(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    


    }

    public static final class FutChangeClientVcb
    {
        public static final int TABLE_INDEX = 20;
        public static final int MSG_ID = 33;
	public static final int MSG_SIZE = 71;
        private java.nio.ByteBuffer data;

        public FutChangeClientVcb() {
            
        }

        public FutChangeClientVcb(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_mode() {
            data.position(8);
            return data.getInt();
        }

        public void set_mode(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public String get_code() {
            data.position(12);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 3);
        }

        public void set_code(String val) {
            data.position(12);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 3);
        }

        
    
        public String get_code_vcb() {
            data.position(16);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(16);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_coeff_go() {
            data.position(42);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_coeff_go(String val) {
            data.position(42);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public String get_limit_spot() {
            data.position(60);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 10);
        }

        public void set_limit_spot(String val) {
            data.position(60);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 10);
        }

        
    


    }

    public static final class FORTS_MSG106
    {
        public static final int TABLE_INDEX = 21;
        public static final int MSG_ID = 106;
	public static final int MSG_SIZE = 260;
        private java.nio.ByteBuffer data;

        public FORTS_MSG106() {
            
        }

        public FORTS_MSG106(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    


    }

    public static final class FutChangeBrokerVcb
    {
        public static final int TABLE_INDEX = 22;
        public static final int MSG_ID = 14;
	public static final int MSG_SIZE = 49;
        private java.nio.ByteBuffer data;

        public FutChangeBrokerVcb() {
            
        }

        public FutChangeBrokerVcb(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_mode() {
            data.position(8);
            return data.getInt();
        }

        public void set_mode(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public String get_code_vcb() {
            data.position(12);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(12);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_limit_spot() {
            data.position(38);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 10);
        }

        public void set_limit_spot(String val) {
            data.position(38);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 10);
        }

        
    


    }

    public static final class FORTS_MSG114
    {
        public static final int TABLE_INDEX = 23;
        public static final int MSG_ID = 114;
	public static final int MSG_SIZE = 260;
        private java.nio.ByteBuffer data;

        public FORTS_MSG114() {
            
        }

        public FORTS_MSG114(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    


    }

    public static final class FutChangeBFMoney
    {
        public static final int TABLE_INDEX = 24;
        public static final int MSG_ID = 7;
	public static final int MSG_SIZE = 51;
        private java.nio.ByteBuffer data;

        public FutChangeBFMoney() {
            
        }

        public FutChangeBFMoney(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_mode() {
            data.position(8);
            return data.getInt();
        }

        public void set_mode(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public String get_code() {
            data.position(12);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 2);
        }

        public void set_code(String val) {
            data.position(12);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 2);
        }

        
    
        public String get_limit_money() {
            data.position(15);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_limit_money(String val) {
            data.position(15);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public String get_limit_pledge() {
            data.position(33);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_limit_pledge(String val) {
            data.position(33);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    


    }

    public static final class FORTS_MSG107
    {
        public static final int TABLE_INDEX = 25;
        public static final int MSG_ID = 107;
	public static final int MSG_SIZE = 260;
        private java.nio.ByteBuffer data;

        public FORTS_MSG107() {
            
        }

        public FORTS_MSG107(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    


    }

    public static final class FutChangeMoney
    {
        public static final int TABLE_INDEX = 26;
        public static final int MSG_ID = 16;
	public static final int MSG_SIZE = 40;
        private java.nio.ByteBuffer data;

        public FutChangeMoney() {
            
        }

        public FutChangeMoney(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_mode() {
            data.position(8);
            return data.getInt();
        }

        public void set_mode(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public String get_limit_spot_buy() {
            data.position(12);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_limit_spot_buy(String val) {
            data.position(12);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public int get_is_auto_update_spot_limit() {
            data.position(32);
            return data.getInt();
        }

        public void set_is_auto_update_spot_limit(int val) {
            data.position(32);
            data.putInt(val);
        }

        
    
        public int get_state() {
            data.position(36);
            return data.getInt();
        }

        public void set_state(int val) {
            data.position(36);
            data.putInt(val);
        }

        
    


    }

    public static final class FORTS_MSG116
    {
        public static final int TABLE_INDEX = 27;
        public static final int MSG_ID = 116;
	public static final int MSG_SIZE = 260;
        private java.nio.ByteBuffer data;

        public FORTS_MSG116() {
            
        }

        public FORTS_MSG116(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    


    }

    public static final class OptChangeExpiration
    {
        public static final int TABLE_INDEX = 28;
        public static final int MSG_ID = 12;
	public static final int MSG_SIZE = 52;
        private java.nio.ByteBuffer data;

        public OptChangeExpiration() {
            
        }

        public OptChangeExpiration(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_mode() {
            data.position(8);
            return data.getInt();
        }

        public void set_mode(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public int get_order_id() {
            data.position(12);
            return data.getInt();
        }

        public void set_order_id(int val) {
            data.position(12);
            data.putInt(val);
        }

        
    
        public String get_code() {
            data.position(16);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 3);
        }

        public void set_code(String val) {
            data.position(16);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 3);
        }

        
    
        public String get_isin() {
            data.position(20);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(20);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public int get_amount() {
            data.position(48);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(48);
            data.putInt(val);
        }

        
    


    }

    public static final class FORTS_MSG112
    {
        public static final int TABLE_INDEX = 29;
        public static final int MSG_ID = 112;
	public static final int MSG_SIZE = 264;
        private java.nio.ByteBuffer data;

        public FORTS_MSG112() {
            
        }

        public FORTS_MSG112(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    
        public int get_order_id() {
            data.position(260);
            return data.getInt();
        }

        public void set_order_id(int val) {
            data.position(260);
            data.putInt(val);
        }

        
    


    }

    public static final class FutChangeClientProhibit
    {
        public static final int TABLE_INDEX = 30;
        public static final int MSG_ID = 15;
	public static final int MSG_SIZE = 76;
        private java.nio.ByteBuffer data;

        public FutChangeClientProhibit() {
            
        }

        public FutChangeClientProhibit(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_mode() {
            data.position(8);
            return data.getInt();
        }

        public void set_mode(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public String get_code() {
            data.position(12);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 3);
        }

        public void set_code(String val) {
            data.position(12);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 3);
        }

        
    
        public String get_code_vcb() {
            data.position(16);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(16);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_isin() {
            data.position(42);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(42);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public int get_state() {
            data.position(68);
            return data.getInt();
        }

        public void set_state(int val) {
            data.position(68);
            data.putInt(val);
        }

        
    
        public int get_state_mask() {
            data.position(72);
            return data.getInt();
        }

        public void set_state_mask(int val) {
            data.position(72);
            data.putInt(val);
        }

        
    


    }

    public static final class FORTS_MSG115
    {
        public static final int TABLE_INDEX = 31;
        public static final int MSG_ID = 115;
	public static final int MSG_SIZE = 260;
        private java.nio.ByteBuffer data;

        public FORTS_MSG115() {
            
        }

        public FORTS_MSG115(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    


    }

    public static final class OptChangeClientProhibit
    {
        public static final int TABLE_INDEX = 32;
        public static final int MSG_ID = 17;
	public static final int MSG_SIZE = 76;
        private java.nio.ByteBuffer data;

        public OptChangeClientProhibit() {
            
        }

        public OptChangeClientProhibit(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_mode() {
            data.position(8);
            return data.getInt();
        }

        public void set_mode(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public String get_code() {
            data.position(12);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 3);
        }

        public void set_code(String val) {
            data.position(12);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 3);
        }

        
    
        public String get_code_vcb() {
            data.position(16);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(16);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_isin() {
            data.position(42);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(42);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public int get_state() {
            data.position(68);
            return data.getInt();
        }

        public void set_state(int val) {
            data.position(68);
            data.putInt(val);
        }

        
    
        public int get_state_mask() {
            data.position(72);
            return data.getInt();
        }

        public void set_state_mask(int val) {
            data.position(72);
            data.putInt(val);
        }

        
    


    }

    public static final class FORTS_MSG117
    {
        public static final int TABLE_INDEX = 33;
        public static final int MSG_ID = 117;
	public static final int MSG_SIZE = 260;
        private java.nio.ByteBuffer data;

        public FORTS_MSG117() {
            
        }

        public FORTS_MSG117(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    


    }

    public static final class FutExchangeBFMoney
    {
        public static final int TABLE_INDEX = 34;
        public static final int MSG_ID = 33;
	public static final int MSG_SIZE = 54;
        private java.nio.ByteBuffer data;

        public FutExchangeBFMoney() {
            
        }

        public FutExchangeBFMoney(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_mode() {
            data.position(8);
            return data.getInt();
        }

        public void set_mode(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    
        public String get_code_from() {
            data.position(12);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 2);
        }

        public void set_code_from(String val) {
            data.position(12);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 2);
        }

        
    
        public String get_code_to() {
            data.position(15);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 2);
        }

        public void set_code_to(String val) {
            data.position(15);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 2);
        }

        
    
        public String get_amount_money() {
            data.position(18);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_amount_money(String val) {
            data.position(18);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    
        public String get_amount_pledge() {
            data.position(36);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 17);
        }

        public void set_amount_pledge(String val) {
            data.position(36);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 17);
        }

        
    


    }

    public static final class FORTS_MSG130
    {
        public static final int TABLE_INDEX = 35;
        public static final int MSG_ID = 130;
	public static final int MSG_SIZE = 260;
        private java.nio.ByteBuffer data;

        public FORTS_MSG130() {
            
        }

        public FORTS_MSG130(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    


    }

    public static final class OptRecalcCS
    {
        public static final int TABLE_INDEX = 36;
        public static final int MSG_ID = 45;
	public static final int MSG_SIZE = 12;
        private java.nio.ByteBuffer data;

        public OptRecalcCS() {
            
        }

        public OptRecalcCS(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public String get_broker_code() {
            data.position(0);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 4);
        }

        public void set_broker_code(String val) {
            data.position(0);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 4);
        }

        
    
        public int get_isin_id() {
            data.position(8);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(8);
            data.putInt(val);
        }

        
    


    }

    public static final class FORTS_MSG132
    {
        public static final int TABLE_INDEX = 37;
        public static final int MSG_ID = 132;
	public static final int MSG_SIZE = 260;
        private java.nio.ByteBuffer data;

        public FORTS_MSG132() {
            
        }

        public FORTS_MSG132(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    


    }

    public static final class FORTS_MSG99
    {
        public static final int TABLE_INDEX = 38;
        public static final int MSG_ID = 99;
	public static final int MSG_SIZE = 144;
        private java.nio.ByteBuffer data;

        public FORTS_MSG99() {
            
        }

        public FORTS_MSG99(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_queue_size() {
            data.position(0);
            return data.getInt();
        }

        public void set_queue_size(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public int get_penalty_remain() {
            data.position(4);
            return data.getInt();
        }

        public void set_penalty_remain(int val) {
            data.position(4);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(8);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 128);
        }

        public void set_message(String val) {
            data.position(8);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 128);
        }

        
    
        public int get_code() {
            data.position(140);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(140);
            data.putInt(val);
        }

        
    


    }

    public static final class FORTS_MSG100
    {
        public static final int TABLE_INDEX = 39;
        public static final int MSG_ID = 100;
	public static final int MSG_SIZE = 260;
        private java.nio.ByteBuffer data;

        public FORTS_MSG100() {
            
        }

        public FORTS_MSG100(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public int get_code() {
            data.position(0);
            return data.getInt();
        }

        public void set_code(int val) {
            data.position(0);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(4);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_message(String val) {
            data.position(4);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    


    }

}

