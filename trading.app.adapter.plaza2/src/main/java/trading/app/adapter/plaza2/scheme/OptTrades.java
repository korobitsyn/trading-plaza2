package trading.app.adapter.plaza2.scheme;

public final class OptTrades
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class orders_log
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 210;
        private java.nio.ByteBuffer data;

        public orders_log() {
            
        }

        public orders_log(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public long get_id_ord() {
            data.position(24);
            return data.getLong();
        }

        public void set_id_ord(long val) {
            data.position(24);
            data.putLong(val);
        }

        
    
        public int get_sess_id() {
            data.position(32);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(32);
            data.putInt(val);
        }

        
    
        public String get_client_code() {
            data.position(36);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(36);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public java.util.Date get_moment() {
            data.position(44);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment(java.util.Date val) {
            data.position(44);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public int get_status() {
            data.position(56);
            return data.getInt();
        }

        public void set_status(int val) {
            data.position(56);
            data.putInt(val);
        }

        
    
        public byte get_action() {
            data.position(60);
            return data.get();
        }

        public void set_action(byte val) {
            data.position(60);
            data.put(val);
        }

        
    
        public int get_isin_id() {
            data.position(64);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(64);
            data.putInt(val);
        }

        
    
        public byte get_dir() {
            data.position(68);
            return data.get();
        }

        public void set_dir(byte val) {
            data.position(68);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_price() {
            data.position(69);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price(java.math.BigDecimal val) {
            data.position(69);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_scale() {
            data.position(69);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_amount() {
            data.position(80);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(80);
            data.putInt(val);
        }

        
    
        public int get_amount_rest() {
            data.position(84);
            return data.getInt();
        }

        public void set_amount_rest(int val) {
            data.position(84);
            data.putInt(val);
        }

        
    
        public String get_comment() {
            data.position(88);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_comment(String val) {
            data.position(88);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public byte get_hedge() {
            data.position(109);
            return data.get();
        }

        public void set_hedge(byte val) {
            data.position(109);
            data.put(val);
        }

        
    
        public byte get_trust() {
            data.position(110);
            return data.get();
        }

        public void set_trust(byte val) {
            data.position(110);
            data.put(val);
        }

        
    
        public int get_ext_id() {
            data.position(112);
            return data.getInt();
        }

        public void set_ext_id(int val) {
            data.position(112);
            data.putInt(val);
        }

        
    
        public String get_login_from() {
            data.position(116);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_login_from(String val) {
            data.position(116);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public String get_broker_to() {
            data.position(137);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_broker_to(String val) {
            data.position(137);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public String get_broker_to_rts() {
            data.position(145);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_broker_to_rts(String val) {
            data.position(145);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public java.util.Date get_date_exp() {
            data.position(154);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_date_exp(java.util.Date val) {
            data.position(154);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public long get_id_ord1() {
            data.position(164);
            return data.getLong();
        }

        public void set_id_ord1(long val) {
            data.position(164);
            data.putLong(val);
        }

        
    
        public String get_broker_from_rts() {
            data.position(172);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_broker_from_rts(String val) {
            data.position(172);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public long get_id_deal() {
            data.position(180);
            return data.getLong();
        }

        public void set_id_deal(long val) {
            data.position(180);
            data.putLong(val);
        }

        
    
        public java.math.BigDecimal get_deal_price() {
            data.position(188);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_deal_price(java.math.BigDecimal val) {
            data.position(188);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_deal_price_scale() {
            data.position(188);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_local_stamp() {
            data.position(200);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_local_stamp(java.util.Date val) {
            data.position(200);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class deal
    {
        public static final int TABLE_INDEX = 1;
        
	public static final int MSG_SIZE = 268;
        private java.nio.ByteBuffer data;

        public deal() {
            
        }

        public deal(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public long get_id_deal() {
            data.position(24);
            return data.getLong();
        }

        public void set_id_deal(long val) {
            data.position(24);
            data.putLong(val);
        }

        
    
        public int get_sess_id() {
            data.position(32);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(32);
            data.putInt(val);
        }

        
    
        public int get_isin_id() {
            data.position(36);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(36);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_price() {
            data.position(40);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price(java.math.BigDecimal val) {
            data.position(40);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_scale() {
            data.position(40);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_amount() {
            data.position(52);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(52);
            data.putInt(val);
        }

        
    
        public java.util.Date get_moment() {
            data.position(56);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment(java.util.Date val) {
            data.position(56);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public String get_code_sell() {
            data.position(66);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_code_sell(String val) {
            data.position(66);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public String get_code_buy() {
            data.position(74);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_code_buy(String val) {
            data.position(74);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public long get_id_ord_sell() {
            data.position(84);
            return data.getLong();
        }

        public void set_id_ord_sell(long val) {
            data.position(84);
            data.putLong(val);
        }

        
    
        public int get_ext_id_sell() {
            data.position(92);
            return data.getInt();
        }

        public void set_ext_id_sell(int val) {
            data.position(92);
            data.putInt(val);
        }

        
    
        public String get_comment_sell() {
            data.position(96);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_comment_sell(String val) {
            data.position(96);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public byte get_trust_sell() {
            data.position(117);
            return data.get();
        }

        public void set_trust_sell(byte val) {
            data.position(117);
            data.put(val);
        }

        
    
        public int get_status_sell() {
            data.position(120);
            return data.getInt();
        }

        public void set_status_sell(int val) {
            data.position(120);
            data.putInt(val);
        }

        
    
        public long get_id_ord_buy() {
            data.position(124);
            return data.getLong();
        }

        public void set_id_ord_buy(long val) {
            data.position(124);
            data.putLong(val);
        }

        
    
        public int get_ext_id_buy() {
            data.position(132);
            return data.getInt();
        }

        public void set_ext_id_buy(int val) {
            data.position(132);
            data.putInt(val);
        }

        
    
        public String get_comment_buy() {
            data.position(136);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_comment_buy(String val) {
            data.position(136);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public byte get_trust_buy() {
            data.position(157);
            return data.get();
        }

        public void set_trust_buy(byte val) {
            data.position(157);
            data.put(val);
        }

        
    
        public int get_status_buy() {
            data.position(160);
            return data.getInt();
        }

        public void set_status_buy(int val) {
            data.position(160);
            data.putInt(val);
        }

        
    
        public int get_pos() {
            data.position(164);
            return data.getInt();
        }

        public void set_pos(int val) {
            data.position(164);
            data.putInt(val);
        }

        
    
        public byte get_nosystem() {
            data.position(168);
            return data.get();
        }

        public void set_nosystem(byte val) {
            data.position(168);
            data.put(val);
        }

        
    
        public byte get_hedge_sell() {
            data.position(169);
            return data.get();
        }

        public void set_hedge_sell(byte val) {
            data.position(169);
            data.put(val);
        }

        
    
        public byte get_hedge_buy() {
            data.position(170);
            return data.get();
        }

        public void set_hedge_buy(byte val) {
            data.position(170);
            data.put(val);
        }

        
    
        public String get_login_sell() {
            data.position(171);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_login_sell(String val) {
            data.position(171);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public String get_login_buy() {
            data.position(192);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_login_buy(String val) {
            data.position(192);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public String get_code_rts_buy() {
            data.position(213);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_code_rts_buy(String val) {
            data.position(213);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public String get_code_rts_sell() {
            data.position(221);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_code_rts_sell(String val) {
            data.position(221);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public java.math.BigDecimal get_fee_sell() {
            data.position(229);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee_sell(java.math.BigDecimal val) {
            data.position(229);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_fee_sell_scale() {
            data.position(229);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_fee_buy() {
            data.position(244);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee_buy(java.math.BigDecimal val) {
            data.position(244);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_fee_buy_scale() {
            data.position(244);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public long get_id_deal_multileg() {
            data.position(260);
            return data.getLong();
        }

        public void set_id_deal_multileg(long val) {
            data.position(260);
            data.putLong(val);
        }

        
    


    }

    public static final class heartbeat
    {
        public static final int TABLE_INDEX = 2;
        
	public static final int MSG_SIZE = 34;
        private java.nio.ByteBuffer data;

        public heartbeat() {
            
        }

        public heartbeat(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public java.util.Date get_server_time() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_server_time(java.util.Date val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class sys_events
    {
        public static final int TABLE_INDEX = 3;
        
	public static final int MSG_SIZE = 105;
        private java.nio.ByteBuffer data;

        public sys_events() {
            
        }

        public sys_events(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public long get_event_id() {
            data.position(24);
            return data.getLong();
        }

        public void set_event_id(long val) {
            data.position(24);
            data.putLong(val);
        }

        
    
        public int get_sess_id() {
            data.position(32);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(32);
            data.putInt(val);
        }

        
    
        public int get_event_type() {
            data.position(36);
            return data.getInt();
        }

        public void set_event_type(int val) {
            data.position(36);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(40);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 64);
        }

        public void set_message(String val) {
            data.position(40);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 64);
        }

        
    


    }

}

