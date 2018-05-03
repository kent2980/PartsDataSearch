package jp.data.model;

/**
 * バーコードから入力した部品コードの文字整形を行うクラス
 * 
 * @author kent
 * @version 0.0.1
 *  @since 0.0.1
 */
public class PartsTextFieldModel {
	private int i = 0;
		/**
		 * デフォルトコンストラクタ
		 */
		public PartsTextFieldModel(String partsName) {
			setPartsName(partsName);
		}
		
		/**
		 * 部品コード名称
		 */
		private String partsName;
		
		/**
		 * 部品コードを設定する <br>
		 *  コード既定に沿わない場合は、「unknown」に設定します
		 * @param partsName 部品コード
		 */
		public void setPartsName(String partsName) {
			String startCode = partsName.substring(0, 3).toUpperCase();
			switch(startCode) {
			case "3N1":
				this.partsName = barcodePartsDesign(partsName);			
				i = 1;
				break;
			case "3N2":
				this.partsName = "1列目のバーコードを読んでください";
				i = 2;
				break;
			default:
				this.partsName = partsName.toUpperCase();
				i = 3;
			}			
		}

		/* 
		 * 部品コード名称を返します
		 */
		public String getPartsName() {
			return partsName;
		}
		
		/**
		 * 部品コードの整形を行います
		 */
		private String barcodePartsDesign(String barcode) {
			int n = barcode.indexOf(" ");
			return barcode.substring(3, n)
													   .replace("-", "")
													   .toUpperCase();
		}

		/* (非 Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((partsName == null) ? 0 : partsName.hashCode());
			return result;
		}

		/* (非 Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PartsTextFieldModel other = (PartsTextFieldModel) obj;
			if (partsName == null) {
				if (other.partsName != null)
					return false;
			} else if (!partsName.equals(other.partsName))
				return false;
			return true;
		}

		/* (非 Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("PartsTextFieldModel [partsName=");
			builder.append(partsName);
			builder.append("]");
			return builder.toString();
		}
		
		public int getValueCode() {
			return i;
		}

}