package trading.app.adapter.plaza2.scheme;

public final class MiscInfo
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class volat_coeff
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 88;
        private java.nio.ByteBuffer data;

        public volat_coeff() {
            
        }

        public volat_coeff(java.nio.ByteBuffer data) {
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

        
    
        public java.math.BigDecimal get_a() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_a(java.math.BigDecimal val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.10", val);
        }

        
        public byte get_a_scale() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_b() {
            data.position(38);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_b(java.math.BigDecimal val) {
            data.position(38);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.10", val);
        }

        
        public byte get_b_scale() {
            data.position(38);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_c() {
            data.position(48);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_c(java.math.BigDecimal val) {
            data.position(48);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.10", val);
        }

        
        public byte get_c_scale() {
            data.position(48);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_d() {
            data.position(58);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_d(java.math.BigDecimal val) {
            data.position(58);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.10", val);
        }

        
        public byte get_d_scale() {
            data.position(58);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_e() {
            data.position(68);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_e(java.math.BigDecimal val) {
            data.position(68);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.10", val);
        }

        
        public byte get_e_scale() {
            data.position(68);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_s() {
            data.position(78);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_s(java.math.BigDecimal val) {
            data.position(78);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.10", val);
        }

        
        public byte get_s_scale() {
            data.position(78);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

}

