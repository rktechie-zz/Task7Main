package databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("transactionId")
public class TransactionShareBean /* implements Comparable<TransactionBean> */ {
        private int customerId;
        private int transactionId;
        private int fundId;
        private String fundName;
        private String executeDate;
        private long shares;
        private long sharePrice;
        private String transactionType;
        private long amount;

        public int getCustomeId() {
                return customerId;
        }

        public void setCustomeId(int customeId) {
                this.customerId = customeId;
        }

        public int getTransactionId() {
                return transactionId;
        }

        public void setTransactionId(int transactionId) {
                this.transactionId = transactionId;
        }

        public int getFundId() {
                return fundId;
        }

        public void setFundId(int fundId) {
                this.fundId = fundId;
        }

        public String getFundName() {
                return fundName;
        }

        public void setFundName(String fundName) {
                this.fundName = fundName;
        }

        public String getExecuteDate() {
                return executeDate;
        }

        public void setExecuteDate(String executeDate) {
                this.executeDate = executeDate;
        }

        public long getShares() {
                return shares;
        }

        public void setShares(long shares) {
                this.shares = shares;
        }

        public long getSharePrice() {
                return sharePrice;
        }

        public void setSharePrice(long sharePrice) {
                this.sharePrice = sharePrice;
        }

        public String getTransactionType() {
                return transactionType;
        }

        public void setTransactionType(String transactionType) {
                this.transactionType = transactionType;
        }

        public long getAmount() {
                return amount;
        }

        public void setAmount(long amount) {
                this.amount = amount;
        }
}
