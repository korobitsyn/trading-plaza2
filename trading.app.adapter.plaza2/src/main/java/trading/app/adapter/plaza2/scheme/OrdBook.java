package trading.app.adapter.plaza2.scheme;

public final class OrdBook
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class orders
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 104;
        private java.nio.ByteBuffer data;

        public orders() {
            
        }

        public orders(java.nio.ByteBuffer data) {
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

        
    
        public java.util.Date get_init_moment() {
            data.position(88);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_init_moment(java.util.Date val) {
            data.position(88);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public int get_init_amount() {
            data.position(100);
            return data.getInt();
        }

        public void set_init_amount(int val) {
            data.position(100);
            data.putInt(val);
        }

        
    


    }

    public static final class info
    {
        public static final int TABLE_INDEX = 1;
        
	public static final int MSG_SIZE = 50;
        private java.nio.ByteBuffer data;

        public info() {
            
        }

        public info(java.nio.ByteBuffer data) {
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

        
    
        public long get_infoID() {
            data.position(24);
            return data.getLong();
        }

        public void set_infoID(long val) {
            data.position(24);
            data.putLong(val);
        }

        
    
        public long get_logRev() {
            data.position(32);
            return data.getLong();
        }

        public void set_logRev(long val) {
            data.position(32);
            data.putLong(val);
        }

        
    
        public java.util.Date get_moment() {
            data.position(40);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment(java.util.Date val) {
            data.position(40);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

}

