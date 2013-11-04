package trading.app.adapter.plaza2.scheme;

public final class OrdersAggr
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class orders_aggr
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 59;
        private java.nio.ByteBuffer data;

        public orders_aggr() {
            
        }

        public orders_aggr(java.nio.ByteBuffer data) {
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

        
    
        public java.math.BigDecimal get_price() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price(java.math.BigDecimal val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_scale() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public long get_volume() {
            data.position(40);
            return data.getLong();
        }

        public void set_volume(long val) {
            data.position(40);
            data.putLong(val);
        }

        
    
        public java.util.Date get_moment() {
            data.position(48);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment(java.util.Date val) {
            data.position(48);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public byte get_dir() {
            data.position(58);
            return data.get();
        }

        public void set_dir(byte val) {
            data.position(58);
            data.put(val);
        }

        
    


    }

}

