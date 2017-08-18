package cn.retrofitsam.bean;

import java.util.List;

/**
 * Created by huxz on 2017/8/17.
 */

public class NewsEntity {

    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"6d2088f025a292d2108ff27d703c16db","title":"暧昧坏境下戏谑生活 《破局》能否创造高质量翻拍","date":"2017-08-17 09:30","category":"头条","author_name":"凤凰网","url":"http://mini.eastday.com/mobile/170817093010694.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170817/20170817093010_d41d8cd98f00b204e9800998ecf8427e_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170817/20170817093010_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170817/20170817093010_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03200403.jpg"}]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"6d2088f025a292d2108ff27d703c16db","title":"暧昧坏境下戏谑生活 《破局》能否创造高质量翻拍","date":"2017-08-17 09:30","category":"头条","author_name":"凤凰网","url":"http://mini.eastday.com/mobile/170817093010694.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170817/20170817093010_d41d8cd98f00b204e9800998ecf8427e_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170817/20170817093010_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170817/20170817093010_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03200403.jpg"}]
         */

        private String stat;
        private List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * uniquekey : 6d2088f025a292d2108ff27d703c16db
             * title : 暧昧坏境下戏谑生活 《破局》能否创造高质量翻拍
             * date : 2017-08-17 09:30
             * category : 头条
             * author_name : 凤凰网
             * url : http://mini.eastday.com/mobile/170817093010694.html
             * thumbnail_pic_s : http://01.imgmini.eastday.com/mobile/20170817/20170817093010_d41d8cd98f00b204e9800998ecf8427e_3_mwpm_03200403.jpg
             * thumbnail_pic_s02 : http://01.imgmini.eastday.com/mobile/20170817/20170817093010_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg
             * thumbnail_pic_s03 : http://01.imgmini.eastday.com/mobile/20170817/20170817093010_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03200403.jpg
             */

            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }
}
