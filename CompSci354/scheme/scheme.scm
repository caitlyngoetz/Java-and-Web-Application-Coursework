;Caitlyn Goetz
;CS 354
;Scheme search and replace program

(define (replace source search-for replace-with)
	(cond ((null? source) '())
	      ((equal? source search-for) (copy replace-with))
	      (else (let ((next (car source))
			(rest (cdr source)))	
		(cons (if (not (list? next))
			next
			(replace next search-for replace-with))
		(replace rest search-for replace-with))))))

(define (copy source)
	(if (null? source) '()
		(if (list? source) (cons (copy (car source)) (copy (cdr source)))
								source)))

(display "\n")
(display (replace 1 1 7))
(display "\n")

(display (replace '(a (b c) d) '(b c) '(x y)))
(display "\n")

(display (replace '(a (b c) (d (b c ))) '(b c) '(x y)))
(display "\n")

(display (replace '(a b c) '(a b) '(x y)))
(display "\n")

(display (replace '(a b c) '(c) '(x)))
(display "\n")

(display (replace '(a b c) '(b c) '(x y z)))
(display "\n")

(display (replace '(a (b c) (d (b d))) '(b d) '()))
(display "\n")
