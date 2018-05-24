package jp.data.model;

import java.time.LocalDateTime;

/**
 * FromTimeを表すシングルトンクラス
 * 作業の開始と終了を管理します。
 * @author kent2
 *
 */
public class FromTimeLoader {
	private static FromTimeLoader loader = new FromTimeLoader();
	private LocalDateTime fromTime;

	private FromTimeLoader() {}

	public static FromTimeLoader getInstance() {
		return loader;
	}

	public void setNowFromTime() {
		fromTime = LocalDateTime.now();
	}

	public LocalDateTime getFromTime() {
		return fromTime;
	}

	public void deleteFromTime() {
		fromTime = null;
	}
}
