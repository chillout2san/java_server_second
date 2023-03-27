package presentation;

public enum ErrorCode {
  /**
   * 原因が分からなかった。
   */
  UNKNOWN,
  /**
   * ドメインモデルのファクトリ関数の引数が渡されなかった。
   */
  DOMAIN_MODEL_ARGUMENT_REQUIRED_ERROR,
  /**
   * DatabaseSessionFactory を作成できなかった。
   */
  DATABASE_SESSION_FACTORY_ERROR
}
