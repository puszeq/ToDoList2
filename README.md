W projekcie została wykorzystana funkcjonalność internacjonalizacji.

Internacjonalizacja polega na stworzeniu klasy implementującej interfejs WebMvcConfigurer. W projekcie jest 
to klasa "Internationalization". 

Na początku należy utworzyć beany reprezentujące klasy LocaleResolver oraz LocaleChangeInterceptor.
Pierwszy bean odpowiedzialny jest za utworzenie obiektu klasy SessionLocaleResolver 
oraz określenia domyślnego języka aplikacji. Drugi bean zawiera w sobie tworzenie obiektu klasy LocaleChangeInterceptor
oraz ustawienie nazwy parametru odpowiedzialnego za przechowywanie danych dotyczących aktualnie używanego języka.

Całość opiera się na plikach o rozszerzeniu "properites", które przechowywują teksty w odpowiednim języku.
Domyślną nazwą pliku przechowującego wartości tekstowe aplikacji jest "message". Wartość tą można zmienić za pomocą odpowiednich właściwości zawartych
w appilcation.properties.

Pliki zawierające teksty w innych językach muszą posiadać odpowiedni dopisek, np. "_pl". W ten sposób po zmianie
parametru lang na pl, aplikacja będzie szukać odpowiednich wartości tekstowych w pliku message_pl.properties.
Jeśli takowe nie zostaną znalezione, aplikacja odwoła się do domyślnego pliku message.properties.

Gdy tłumaczenia zostaną już przygotowane, skorzystam z nich poprzez zmianę wartości parametru lang, czyli
dodanie do aktualnego adresu url wartości "?lang=", przykładowo "?lang=pl".
