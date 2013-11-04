package trading.app.adapter.plaza2.scheme;

public final class Rates
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class curr_online
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 50;
        private java.nio.ByteBuffer data;

        public curr_online() {
            
        }

        public curr_online(java.nio.ByteBuffer data) {
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

        
    
        public int get_rate_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_rate_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_value() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_value(java.math.BigDecimal val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_value_scale() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
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

