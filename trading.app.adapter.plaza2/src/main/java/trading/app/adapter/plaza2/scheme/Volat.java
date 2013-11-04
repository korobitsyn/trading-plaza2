package trading.app.adapter.plaza2.scheme;

public final class Volat
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class volat
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 65;
        private java.nio.ByteBuffer data;

        public volat() {
            
        }

        public volat(java.nio.ByteBuffer data) {
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

        
    
        public int get_sess_id() {
            data.position(28);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(28);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_volat() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_volat(java.math.BigDecimal val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_volat_scale() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_theor_price() {
            data.position(43);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_theor_price(java.math.BigDecimal val) {
            data.position(43);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_theor_price_scale() {
            data.position(43);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_theor_price_limit() {
            data.position(54);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_theor_price_limit(java.math.BigDecimal val) {
            data.position(54);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_theor_price_limit_scale() {
            data.position(54);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

}

