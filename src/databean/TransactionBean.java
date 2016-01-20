package databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("transactionId")
public class TransactionBean /* implements Comparable<TransactionBean> */ {

        private int customerId;
        private int transactionId;
        private String userName;
        private int fundId;
        private String executeDate;
        private long shares;
        private String transactionType;
        private long amount;

        public int getCustomerId() {
                return customerId;
        }

        public void setCustomerId(int customer_id) {
                this.customerId= customer_id;
        }

        public void setTransactionId(int v) {
                transactionId = v;
        }

        public void setUserName(String v) {
                userName = v;
        }

        public void setFundId(int v) {
                fundId = v;
        }

        public void setExecuteDate(String today) {
                executeDate = today;
        }

        public void setShares(long v) {
                shares = v;
        }

        public void setTransactionType(String v) {
                transactionType = v;
        }

        public void setAmount(long v) {
                amount = v;
        }

        public int getTransactionId() {
                return transactionId;
        }

        public String getUserName() {
                return userName;
        }

        public int getFundId() {
                return fundId;
        }

        public String getExecuteDate() {
                return executeDate;
        }

        public long getShares() {
                return shares;
        }

        public String getTransactionType() {
                return transactionType;
        }

        public long getAmount() {
                return amount;
        }
}
