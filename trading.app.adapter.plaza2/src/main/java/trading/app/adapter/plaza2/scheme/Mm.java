package trading.app.adapter.plaza2.scheme;
public final class Mm
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class fut_MM_info
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 136;
        private java.nio.ByteBuffer data;

        public fut_MM_info() {
            
        }

        public fut_MM_info(java.nio.ByteBuffer data) {
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

        
    
        public java.math.BigDecimal get_spread() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_spread(java.math.BigDecimal val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_spread_scale() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_price_edge_sell() {
            data.position(43);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price_edge_sell(java.math.BigDecimal val) {
            data.position(43);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_edge_sell_scale() {
            data.position(43);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_amount_sells() {
            data.position(56);
            return data.getInt();
        }

        public void set_amount_sells(int val) {
            data.position(56);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_price_edge_buy() {
            data.position(60);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price_edge_buy(java.math.BigDecimal val) {
            data.position(60);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_edge_buy_scale() {
            data.position(60);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_amount_buys() {
            data.position(72);
            return data.getInt();
        }

        public void set_amount_buys(int val) {
            data.position(72);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_mm_spread() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_mm_spread(java.math.BigDecimal val) {
            data.position(76);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_mm_spread_scale() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_mm_amount() {
            data.position(88);
            return data.getInt();
        }

        public void set_mm_amount(int val) {
            data.position(88);
            data.putInt(val);
        }

        
    
        public byte get_spread_sign() {
            data.position(92);
            return data.get();
        }

        public void set_spread_sign(byte val) {
            data.position(92);
            data.put(val);
        }

        
    
        public byte get_amount_sign() {
            data.position(93);
            return data.get();
        }

        public void set_amount_sign(byte val) {
            data.position(93);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_percent_time() {
            data.position(94);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_percent_time(java.math.BigDecimal val) {
            data.position(94);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d6.2", val);
        }

        
        public byte get_percent_time_scale() {
            data.position(94);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_period_start() {
            data.position(100);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_period_start(java.util.Date val) {
            data.position(100);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.util.Date get_period_end() {
            data.position(110);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_period_end(java.util.Date val) {
            data.position(110);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public String get_client_code() {
            data.position(120);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(120);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public int get_active_sign() {
            data.position(128);
            return data.getInt();
        }

        public void set_active_sign(int val) {
            data.position(128);
            data.putInt(val);
        }

        
    
        public int get_agmt_id() {
            data.position(132);
            return data.getInt();
        }

        public void set_agmt_id(int val) {
            data.position(132);
            data.putInt(val);
        }

        
    


    }

    public static final class opt_MM_info
    {
        public static final int TABLE_INDEX = 1;
        
	public static final int MSG_SIZE = 148;
        private java.nio.ByteBuffer data;

        public opt_MM_info() {
            
        }

        public opt_MM_info(java.nio.ByteBuffer data) {
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

        
    
        public java.math.BigDecimal get_spread() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_spread(java.math.BigDecimal val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_spread_scale() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_price_edge_sell() {
            data.position(43);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price_edge_sell(java.math.BigDecimal val) {
            data.position(43);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_edge_sell_scale() {
            data.position(43);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_amount_sells() {
            data.position(56);
            return data.getInt();
        }

        public void set_amount_sells(int val) {
            data.position(56);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_price_edge_buy() {
            data.position(60);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price_edge_buy(java.math.BigDecimal val) {
            data.position(60);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_edge_buy_scale() {
            data.position(60);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_amount_buys() {
            data.position(72);
            return data.getInt();
        }

        public void set_amount_buys(int val) {
            data.position(72);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_mm_spread() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_mm_spread(java.math.BigDecimal val) {
            data.position(76);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_mm_spread_scale() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_mm_amount() {
            data.position(88);
            return data.getInt();
        }

        public void set_mm_amount(int val) {
            data.position(88);
            data.putInt(val);
        }

        
    
        public byte get_spread_sign() {
            data.position(92);
            return data.get();
        }

        public void set_spread_sign(byte val) {
            data.position(92);
            data.put(val);
        }

        
    
        public byte get_amount_sign() {
            data.position(93);
            return data.get();
        }

        public void set_amount_sign(byte val) {
            data.position(93);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_percent_time() {
            data.position(94);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_percent_time(java.math.BigDecimal val) {
            data.position(94);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d6.2", val);
        }

        
        public byte get_percent_time_scale() {
            data.position(94);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_period_start() {
            data.position(100);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_period_start(java.util.Date val) {
            data.position(100);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.util.Date get_period_end() {
            data.position(110);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_period_end(java.util.Date val) {
            data.position(110);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public String get_client_code() {
            data.position(120);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(120);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public java.math.BigDecimal get_cstrike_offset() {
            data.position(128);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_cstrike_offset(java.math.BigDecimal val) {
            data.position(128);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_cstrike_offset_scale() {
            data.position(128);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_active_sign() {
            data.position(140);
            return data.getInt();
        }

        public void set_active_sign(int val) {
            data.position(140);
            data.putInt(val);
        }

        
    
        public int get_agmt_id() {
            data.position(144);
            return data.getInt();
        }

        public void set_agmt_id(int val) {
            data.position(144);
            data.putInt(val);
        }

        
    


    }

}

