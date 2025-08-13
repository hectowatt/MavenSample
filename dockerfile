# OpenJDK 8 をベースに
FROM openjdk:8-jdk

# 作業ディレクトリ
WORKDIR /app

# Maven インストール
# 最新ではなく安定版が欲しい場合は apt の maven を使う
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# ソースコードをコピー
COPY . .

# Maven のバージョン確認
RUN mvn -v

# デフォルトのコマンド
CMD ["mvn", "-v"]
