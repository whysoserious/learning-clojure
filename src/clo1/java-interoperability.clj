(import
 '(java.util Calendar GregorianCalendar)
 '(javax.swing JFrame JLabel))

(. java.util.Calendar APRIL)

(. Calendar APRIL)

java.util.Calendar/APRIL

Calendar/APRIL

(. Math pow 2 4)

(Math/pow 2 4)

(def calendar (new GregorianCalendar 2008 Calendar/APRIL 16))

(def calendar (GregorianCalendar. 2008 Calendar/APRIL 16))

(. calendar add Calendar/MONTH 2)

(. calendar get Calendar/MONTH)

(.add calendar Calendar/MONTH 2)

(.get calendar Calendar/MONTH)

(. (. calendar getTimeZone) getDisplayName)

(.. calendar getTimeZone getDisplayName)

(doto calendar
  (.set Calendar/YEAR 1981)
  (.set Calendar/MONTH Calendar/AUGUST)
  (.set Calendar/DATE 1))

(def formatter (java.text.DateFormat/getDateInstance))

(.format formatter (.getTime calendar))

(map #(.substring %1 %2)
     ["Moe", "Larry", "Curly"]
     [1 2 3])

(map (memfn substring _)
           ["Moe" "Larry" "Curly"]
     [1 2 3])

;; threads

(defn delayed-print [ms]
  (Thread/sleep ms)
  (println "TADA"))

(.start (Thread. #(delayed-print 200)))

