package trading.app.adapter.plaza2.scheme;

public final class FutCommon
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class common
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 256;
        private java.nio.ByteBuffer data;

        public common() {
            
        }

        public common(java.nio.ByteBuffer data) {
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

        
    
        public java.math.BigDecimal get_best_sell() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_best_sell(java.math.BigDecimal val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_best_sell_scale() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_amount_sell() {
            data.position(44);
            return data.getInt();
        }

        public void set_amount_sell(int val) {
            data.position(44);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_best_buy() {
            data.position(48);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_best_buy(java.math.BigDecimal val) {
            data.position(48);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_best_buy_scale() {
            data.position(48);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_amount_buy() {
            data.position(60);
            return data.getInt();
        }

        public void set_amount_buy(int val) {
            data.position(60);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_price() {
            data.position(64);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price(java.math.BigDecimal val) {
            data.position(64);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_scale() {
            data.position(64);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_trend() {
            data.position(75);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_trend(java.math.BigDecimal val) {
            data.position(75);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_trend_scale() {
            data.position(75);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_amount() {
            data.position(88);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(88);
            data.putInt(val);
        }

        
    
        public java.util.Date get_deal_time() {
            data.position(92);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_deal_time(java.util.Date val) {
            data.position(92);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.math.BigDecimal get_min_price() {
            data.position(102);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_min_price(java.math.BigDecimal val) {
            data.position(102);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_min_price_scale() {
            data.position(102);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_max_price() {
            data.position(113);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_max_price(java.math.BigDecimal val) {
            data.position(113);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_max_price_scale() {
            data.position(113);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_avr_price() {
            data.position(124);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_avr_price(java.math.BigDecimal val) {
            data.position(124);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_avr_price_scale() {
            data.position(124);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_old_kotir() {
            data.position(135);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_old_kotir(java.math.BigDecimal val) {
            data.position(135);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_old_kotir_scale() {
            data.position(135);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_deal_count() {
            data.position(148);
            return data.getInt();
        }

        public void set_deal_count(int val) {
            data.position(148);
            data.putInt(val);
        }

        
    
        public int get_contr_count() {
            data.position(152);
            return data.getInt();
        }

        public void set_contr_count(int val) {
            data.position(152);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_capital() {
            data.position(156);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_capital(java.math.BigDecimal val) {
            data.position(156);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_capital_scale() {
            data.position(156);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_pos() {
            data.position(172);
            return data.getInt();
        }

        public void set_pos(int val) {
            data.position(172);
            data.putInt(val);
        }

        
    
        public java.util.Date get_mod_time() {
            data.position(176);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_mod_time(java.util.Date val) {
            data.position(176);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.math.BigDecimal get_cur_kotir() {
            data.position(186);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_cur_kotir(java.math.BigDecimal val) {
            data.position(186);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_cur_kotir_scale() {
            data.position(186);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_cur_kotir_real() {
            data.position(197);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_cur_kotir_real(java.math.BigDecimal val) {
            data.position(197);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_cur_kotir_real_scale() {
            data.position(197);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_orders_sell_qty() {
            data.position(208);
            return data.getInt();
        }

        public void set_orders_sell_qty(int val) {
            data.position(208);
            data.putInt(val);
        }

        
    
        public int get_orders_sell_amount() {
            data.position(212);
            return data.getInt();
        }

        public void set_orders_sell_amount(int val) {
            data.position(212);
            data.putInt(val);
        }

        
    
        public int get_orders_buy_qty() {
            data.position(216);
            return data.getInt();
        }

        public void set_orders_buy_qty(int val) {
            data.position(216);
            data.putInt(val);
        }

        
    
        public int get_orders_buy_amount() {
            data.position(220);
            return data.getInt();
        }

        public void set_orders_buy_amount(int val) {
            data.position(220);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_open_price() {
            data.position(224);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_open_price(java.math.BigDecimal val) {
            data.position(224);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_open_price_scale() {
            data.position(224);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_close_price() {
            data.position(235);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_close_price(java.math.BigDecimal val) {
            data.position(235);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_close_price_scale() {
            data.position(235);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_local_time() {
            data.position(246);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_local_time(java.util.Date val) {
            data.position(246);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

}

