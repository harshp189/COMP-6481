    /**
     * The ArticleModel is a model class build with purpose to retrieve the file contents through various
     * setter and getter methods.
     *
     * @author Harshkumar N. Patel
     * @author Chirag H. Patel
     */

    public class ArticleModel {

        public String authors;
        public String journal;
        public String title;
        public String year;
        public String volume;
        public String number;
        public String pages;
        public String keywords;
        public String ISSN;
        public String month;
        public String doi;
        public boolean isValid;

        public ArticleModel() {
            this.authors = "";
            this.journal = "";
            this.title = "";
            this.year = "";
            this.volume = "";
            this.number = "";
            this.pages = "";
            this.keywords = "";
            this.doi = "";
            this.ISSN = "";
            this.month = "";
        }

        /**
         * @param authors  value of authors field
         * @param journal  value of journal field
         * @param title    value of title field
         * @param year     value of year field
         * @param volume   value of volume field
         * @param number   value of number field
         * @param pages    value of pages field
         * @param keywords value of keywords field
         * @param doi      value of doi field
         * @param ISSN     value of ISSN field
         * @param month    value of month field
         */
        public ArticleModel(String authors, String journal, String title, String year, String volume,
                            String number, String pages, String keywords, String doi, String ISSN, String month) {

            //this.id = id;
            this.authors = authors;
            this.journal = journal;
            this.title = title;
            this.year = year;
            this.volume = volume;
            this.number = number;
            this.pages = pages;
            this.keywords = keywords;
            this.doi = doi;
            this.ISSN = ISSN;
            this.month = month;

        }


    }
