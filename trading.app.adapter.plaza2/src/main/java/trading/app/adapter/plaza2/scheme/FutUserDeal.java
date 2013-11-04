package trading.app.adapter.plaza2.scheme;

public final class FutUserDeal
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class user_deal
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 280;
        private java.nio.ByteBuffer data;

        public user_deal() {
            
        }

        public user_deal(java.nio.ByteBuffer data) {
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

        
    
        public long get_id_deal() {
            data.position(24);
            return data.getLong();
        }

        public void set_id_deal(long val) {
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

        
    
        public int get_isin_id() {
            data.position(36);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(36);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_price() {
            data.position(40);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price(java.math.BigDecimal val) {
            data.position(40);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_scale() {
            data.position(40);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_amount() {
            data.position(52);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(52);
            data.putInt(val);
        }

        
    
        public java.util.Date get_moment() {
            data.position(56);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment(java.util.Date val) {
            data.position(56);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public String get_code_sell() {
            data.position(66);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_code_sell(String val) {
            data.position(66);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public String get_code_buy() {
            data.position(74);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_code_buy(String val) {
            data.position(74);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public long get_id_ord_sell() {
            data.position(84);
            return data.getLong();
        }

        public void set_id_ord_sell(long val) {
            data.position(84);
            data.putLong(val);
        }

        
    
        public int get_ext_id_sell() {
            data.position(92);
            return data.getInt();
        }

        public void set_ext_id_sell(int val) {
            data.position(92);
            data.putInt(val);
        }

        
    
        public String get_comment_sell() {
            data.position(96);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_comment_sell(String val) {
            data.position(96);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public byte get_trust_sell() {
            data.position(117);
            return data.get();
        }

        public void set_trust_sell(byte val) {
            data.position(117);
            data.put(val);
        }

        
    
        public int get_status_sell() {
            data.position(120);
            return data.getInt();
        }

        public void set_status_sell(int val) {
            data.position(120);
            data.putInt(val);
        }

        
    
        public long get_id_ord_buy() {
            data.position(124);
            return data.getLong();
        }

        public void set_id_ord_buy(long val) {
            data.position(124);
            data.putLong(val);
        }

        
    
        public int get_ext_id_buy() {
            data.position(132);
            return data.getInt();
        }

        public void set_ext_id_buy(int val) {
            data.position(132);
            data.putInt(val);
        }

        
    
        public String get_comment_buy() {
            data.position(136);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_comment_buy(String val) {
            data.position(136);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public byte get_trust_buy() {
            data.position(157);
            return data.get();
        }

        public void set_trust_buy(byte val) {
            data.position(157);
            data.put(val);
        }

        
    
        public int get_status_buy() {
            data.position(160);
            return data.getInt();
        }

        public void set_status_buy(int val) {
            data.position(160);
            data.putInt(val);
        }

        
    
        public int get_pos() {
            data.position(164);
            return data.getInt();
        }

        public void set_pos(int val) {
            data.position(164);
            data.putInt(val);
        }

        
    
        public byte get_nosystem() {
            data.position(168);
            return data.get();
        }

        public void set_nosystem(byte val) {
            data.position(168);
            data.put(val);
        }

        
    
        public long get_id_repo() {
            data.position(172);
            return data.getLong();
        }

        public void set_id_repo(long val) {
            data.position(172);
            data.putLong(val);
        }

        
    
        public byte get_hedge_sell() {
            data.position(180);
            return data.get();
        }

        public void set_hedge_sell(byte val) {
            data.position(180);
            data.put(val);
        }

        
    
        public byte get_hedge_buy() {
            data.position(181);
            return data.get();
        }

        public void set_hedge_buy(byte val) {
            data.position(181);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_fee_sell() {
            data.position(182);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee_sell(java.math.BigDecimal val) {
            data.position(182);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_fee_sell_scale() {
            data.position(182);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_fee_buy() {
            data.position(197);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee_buy(java.math.BigDecimal val) {
            data.position(197);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_fee_buy_scale() {
            data.position(197);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public String get_login_sell() {
            data.position(212);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_login_sell(String val) {
            data.position(212);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public String get_login_buy() {
            data.position(233);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_login_buy(String val) {
            data.position(233);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public String get_code_rts_sell() {
            data.position(254);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_code_rts_sell(String val) {
            data.position(254);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public String get_code_rts_buy() {
            data.position(262);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_code_rts_buy(String val) {
            data.position(262);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public long get_id_deal_multileg() {
            data.position(272);
            return data.getLong();
        }

        public void set_id_deal_multileg(long val) {
            data.position(272);
            data.putLong(val);
        }

        
    


    }

}

