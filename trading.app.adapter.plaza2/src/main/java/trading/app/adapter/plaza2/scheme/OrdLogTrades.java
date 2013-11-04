package trading.app.adapter.plaza2.scheme;

public final class OrdLogTrades
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class orders_log
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 99;
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

        
    
        public java.util.Date get_moment() {
            data.position(36);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment(java.util.Date val) {
            data.position(36);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public int get_status() {
            data.position(48);
            return data.getInt();
        }

        public void set_status(int val) {
            data.position(48);
            data.putInt(val);
        }

        
    
        public byte get_action() {
            data.position(52);
            return data.get();
        }

        public void set_action(byte val) {
            data.position(52);
            data.put(val);
        }

        
    
        public int get_isin_id() {
            data.position(56);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(56);
            data.putInt(val);
        }

        
    
        public byte get_dir() {
            data.position(60);
            return data.get();
        }

        public void set_dir(byte val) {
            data.position(60);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_price() {
            data.position(61);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price(java.math.BigDecimal val) {
            data.position(61);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_scale() {
            data.position(61);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_amount() {
            data.position(72);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(72);
            data.putInt(val);
        }

        
    
        public int get_amount_rest() {
            data.position(76);
            return data.getInt();
        }

        public void set_amount_rest(int val) {
            data.position(76);
            data.putInt(val);
        }

        
    
        public long get_id_deal() {
            data.position(80);
            return data.getLong();
        }

        public void set_id_deal(long val) {
            data.position(80);
            data.putLong(val);
        }

        
    
        public java.math.BigDecimal get_deal_price() {
            data.position(88);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_deal_price(java.math.BigDecimal val) {
            data.position(88);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_deal_price_scale() {
            data.position(88);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class multileg_orders_log
    {
        public static final int TABLE_INDEX = 1;
        
	public static final int MSG_SIZE = 123;
        private java.nio.ByteBuffer data;

        public multileg_orders_log() {
            
        }

        public multileg_orders_log(java.nio.ByteBuffer data) {
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

        
    
        public java.util.Date get_moment() {
            data.position(36);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment(java.util.Date val) {
            data.position(36);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public int get_status() {
            data.position(48);
            return data.getInt();
        }

        public void set_status(int val) {
            data.position(48);
            data.putInt(val);
        }

        
    
        public byte get_action() {
            data.position(52);
            return data.get();
        }

        public void set_action(byte val) {
            data.position(52);
            data.put(val);
        }

        
    
        public int get_isin_id() {
            data.position(56);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(56);
            data.putInt(val);
        }

        
    
        public byte get_dir() {
            data.position(60);
            return data.get();
        }

        public void set_dir(byte val) {
            data.position(60);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_price() {
            data.position(61);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price(java.math.BigDecimal val) {
            data.position(61);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_scale() {
            data.position(61);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_amount() {
            data.position(72);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(72);
            data.putInt(val);
        }

        
    
        public int get_amount_rest() {
            data.position(76);
            return data.getInt();
        }

        public void set_amount_rest(int val) {
            data.position(76);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_rate_price() {
            data.position(80);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_rate_price(java.math.BigDecimal val) {
            data.position(80);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_rate_price_scale() {
            data.position(80);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_swap_price() {
            data.position(91);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_swap_price(java.math.BigDecimal val) {
            data.position(91);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_swap_price_scale() {
            data.position(91);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public long get_id_deal() {
            data.position(104);
            return data.getLong();
        }

        public void set_id_deal(long val) {
            data.position(104);
            data.putLong(val);
        }

        
    
        public java.math.BigDecimal get_deal_price() {
            data.position(112);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_deal_price(java.math.BigDecimal val) {
            data.position(112);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_deal_price_scale() {
            data.position(112);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class sys_events
    {
        public static final int TABLE_INDEX = 2;
        
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

