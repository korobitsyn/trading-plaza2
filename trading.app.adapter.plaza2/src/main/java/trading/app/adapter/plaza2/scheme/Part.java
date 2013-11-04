package trading.app.adapter.plaza2.scheme;

public final class Part
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class part
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 316;
        private java.nio.ByteBuffer data;

        public part() {
            
        }

        public part(java.nio.ByteBuffer data) {
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

        
    
        public String get_client_code() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public java.math.BigDecimal get_coeff_go() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_coeff_go(java.math.BigDecimal val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_coeff_go_scale() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_coeff_liquidity() {
            data.position(43);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_coeff_liquidity(java.math.BigDecimal val) {
            data.position(43);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_coeff_liquidity_scale() {
            data.position(43);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_money_old() {
            data.position(54);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_money_old(java.math.BigDecimal val) {
            data.position(54);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_money_old_scale() {
            data.position(54);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_money_amount() {
            data.position(69);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_money_amount(java.math.BigDecimal val) {
            data.position(69);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_money_amount_scale() {
            data.position(69);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_money_free() {
            data.position(84);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_money_free(java.math.BigDecimal val) {
            data.position(84);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_money_free_scale() {
            data.position(84);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_money_blocked() {
            data.position(99);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_money_blocked(java.math.BigDecimal val) {
            data.position(99);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_money_blocked_scale() {
            data.position(99);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_pledge_old() {
            data.position(114);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_pledge_old(java.math.BigDecimal val) {
            data.position(114);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_pledge_old_scale() {
            data.position(114);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_pledge_amount() {
            data.position(129);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_pledge_amount(java.math.BigDecimal val) {
            data.position(129);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_pledge_amount_scale() {
            data.position(129);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_pledge_free() {
            data.position(144);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_pledge_free(java.math.BigDecimal val) {
            data.position(144);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_pledge_free_scale() {
            data.position(144);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_pledge_blocked() {
            data.position(159);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_pledge_blocked(java.math.BigDecimal val) {
            data.position(159);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_pledge_blocked_scale() {
            data.position(159);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_vm_reserve() {
            data.position(174);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vm_reserve(java.math.BigDecimal val) {
            data.position(174);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_vm_reserve_scale() {
            data.position(174);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_vm_intercl() {
            data.position(189);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vm_intercl(java.math.BigDecimal val) {
            data.position(189);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_vm_intercl_scale() {
            data.position(189);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_fee() {
            data.position(204);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee(java.math.BigDecimal val) {
            data.position(204);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_fee_scale() {
            data.position(204);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_fee_reserve() {
            data.position(219);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee_reserve(java.math.BigDecimal val) {
            data.position(219);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_fee_reserve_scale() {
            data.position(219);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_limit_spot_buy() {
            data.position(234);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_limit_spot_buy(java.math.BigDecimal val) {
            data.position(234);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_limit_spot_buy_scale() {
            data.position(234);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_limit_spot_buy_used() {
            data.position(249);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_limit_spot_buy_used(java.math.BigDecimal val) {
            data.position(249);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_limit_spot_buy_used_scale() {
            data.position(249);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public byte get_is_auto_update_limit() {
            data.position(264);
            return data.get();
        }

        public void set_is_auto_update_limit(byte val) {
            data.position(264);
            data.put(val);
        }

        
    
        public byte get_is_auto_update_spot_limit() {
            data.position(265);
            return data.get();
        }

        public void set_is_auto_update_spot_limit(byte val) {
            data.position(265);
            data.put(val);
        }

        
    
        public byte get_no_fut_discount() {
            data.position(266);
            return data.get();
        }

        public void set_no_fut_discount(byte val) {
            data.position(266);
            data.put(val);
        }

        
    
        public byte get_limits_set() {
            data.position(267);
            return data.get();
        }

        public void set_limits_set(byte val) {
            data.position(267);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_premium() {
            data.position(268);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_premium(java.math.BigDecimal val) {
            data.position(268);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_premium_scale() {
            data.position(268);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public double get_premium_order_reserve() {
            data.position(284);
            return data.getDouble();
        }

        public void set_premium_order_reserve(double val) {
            data.position(284);
            data.putDouble(val);
        }

        
    
        public java.math.BigDecimal get_balance_money() {
            data.position(292);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_balance_money(java.math.BigDecimal val) {
            data.position(292);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_balance_money_scale() {
            data.position(292);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public double get_vm_order_reserve() {
            data.position(308);
            return data.getDouble();
        }

        public void set_vm_order_reserve(double val) {
            data.position(308);
            data.putDouble(val);
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

