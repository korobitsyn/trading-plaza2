package trading.app.adapter.plaza2.scheme;

public final class Tnpenalty
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class fee_all
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 118;
        private java.nio.ByteBuffer data;

        public fee_all() {
            
        }

        public fee_all(java.nio.ByteBuffer data) {
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

        
    
        public long get_time() {
            data.position(24);
            return data.getLong();
        }

        public void set_time(long val) {
            data.position(24);
            data.putLong(val);
        }

        
    
        public String get_p2login() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 64);
        }

        public void set_p2login(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 64);
        }

        
    
        public int get_sess_id() {
            data.position(100);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(100);
            data.putInt(val);
        }

        
    
        public int get_points() {
            data.position(104);
            return data.getInt();
        }

        public void set_points(int val) {
            data.position(104);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_fee() {
            data.position(108);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee(java.math.BigDecimal val) {
            data.position(108);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_fee_scale() {
            data.position(108);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class fee_tn
    {
        public static final int TABLE_INDEX = 1;
        
	public static final int MSG_SIZE = 116;
        private java.nio.ByteBuffer data;

        public fee_tn() {
            
        }

        public fee_tn(java.nio.ByteBuffer data) {
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

        
    
        public long get_time() {
            data.position(24);
            return data.getLong();
        }

        public void set_time(long val) {
            data.position(24);
            data.putLong(val);
        }

        
    
        public String get_p2login() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 64);
        }

        public void set_p2login(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 64);
        }

        
    
        public int get_sess_id() {
            data.position(100);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(100);
            data.putInt(val);
        }

        
    
        public int get_tn_type() {
            data.position(104);
            return data.getInt();
        }

        public void set_tn_type(int val) {
            data.position(104);
            data.putInt(val);
        }

        
    
        public int get_err_code() {
            data.position(108);
            return data.getInt();
        }

        public void set_err_code(int val) {
            data.position(108);
            data.putInt(val);
        }

        
    
        public int get_count() {
            data.position(112);
            return data.getInt();
        }

        public void set_count(int val) {
            data.position(112);
            data.putInt(val);
        }

        
    


    }

}

