package trading.app.adapter.plaza2.scheme;

public final class RtsIndex
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class rts_index
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 144;
        private java.nio.ByteBuffer data;

        public rts_index() {
            
        }

        public rts_index(java.nio.ByteBuffer data) {
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

        
    
        public String get_name() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_name(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public java.util.Date get_moment() {
            data.position(50);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment(java.util.Date val) {
            data.position(50);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.math.BigDecimal get_value() {
            data.position(60);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_value(java.math.BigDecimal val) {
            data.position(60);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d18.4", val);
        }

        
        public byte get_value_scale() {
            data.position(60);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_prev_close_value() {
            data.position(71);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_prev_close_value(java.math.BigDecimal val) {
            data.position(71);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d18.4", val);
        }

        
        public byte get_prev_close_value_scale() {
            data.position(71);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_open_value() {
            data.position(82);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_open_value(java.math.BigDecimal val) {
            data.position(82);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d18.4", val);
        }

        
        public byte get_open_value_scale() {
            data.position(82);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_max_value() {
            data.position(93);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_max_value(java.math.BigDecimal val) {
            data.position(93);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d18.4", val);
        }

        
        public byte get_max_value_scale() {
            data.position(93);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_min_value() {
            data.position(104);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_min_value(java.math.BigDecimal val) {
            data.position(104);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d18.4", val);
        }

        
        public byte get_min_value_scale() {
            data.position(104);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_usd_rate() {
            data.position(115);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_usd_rate(java.math.BigDecimal val) {
            data.position(115);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d10.4", val);
        }

        
        public byte get_usd_rate_scale() {
            data.position(115);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_cap() {
            data.position(122);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_cap(java.math.BigDecimal val) {
            data.position(122);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d18.4", val);
        }

        
        public byte get_cap_scale() {
            data.position(122);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_volume() {
            data.position(133);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_volume(java.math.BigDecimal val) {
            data.position(133);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d18.4", val);
        }

        
        public byte get_volume_scale() {
            data.position(133);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

}

