package trading.app.adapter.plaza2.scheme;

public final class Pos
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class position
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 87;
        private java.nio.ByteBuffer data;

        public position() {
            
        }

        public position(java.nio.ByteBuffer data) {
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

        
    
        public int get_isin_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public String get_client_code() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public int get_open_qty() {
            data.position(36);
            return data.getInt();
        }

        public void set_open_qty(int val) {
            data.position(36);
            data.putInt(val);
        }

        
    
        public int get_buys_qty() {
            data.position(40);
            return data.getInt();
        }

        public void set_buys_qty(int val) {
            data.position(40);
            data.putInt(val);
        }

        
    
        public int get_sells_qty() {
            data.position(44);
            return data.getInt();
        }

        public void set_sells_qty(int val) {
            data.position(44);
            data.putInt(val);
        }

        
    
        public int get_pos() {
            data.position(48);
            return data.getInt();
        }

        public void set_pos(int val) {
            data.position(48);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_net_volume_rur() {
            data.position(52);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_net_volume_rur(java.math.BigDecimal val) {
            data.position(52);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_net_volume_rur_scale() {
            data.position(52);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public long get_last_deal_id() {
            data.position(68);
            return data.getLong();
        }

        public void set_last_deal_id(long val) {
            data.position(68);
            data.putLong(val);
        }

        
    
        public java.math.BigDecimal get_waprice() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_waprice(java.math.BigDecimal val) {
            data.position(76);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_waprice_scale() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class sys_events
    {
        public static final int TABLE_INDEX = 1;
        
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

