(ns demo.core
  (:import (java.awt Color Dimension Frame)
           (java.awt.event WindowListener)))

(def exit-on-close
  (proxy [WindowListener] []
    (windowClosing [_]
      (System/exit 0))
    (windowActivated [_])
    (windowDeactivated [_])))

(defn color-values [f xs ys]
  (for [x (range xs) y (range ys)]
    [x y (rem (f x y) 256)]))

(defn draw-frame
  ([f]
     (draw-frame f 500 500))
  ([f xs ys]
     (let [frame (doto (Frame.)
                   (.setVisible true)
                   (.setSize (Dimension. xs ys))
                   (.addWindowListener exit-on-close))
           gfx (.getGraphics frame)]
       (doseq [[x y color] (color-values f xs ys)]
         (.setColor gfx (Color. color color color))
         (.fillRect gfx x y 1 1)))))

(defn -main []
  (draw-frame bit-xor)
  ;;(draw-frame bit-and)
  ;;(draw-frame *)
  ;;(draw-frame +)
  )
