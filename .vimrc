"-------------------------------------------------
"  vimrc file for chris wallace
"  (I got rid of white "background" between tab blocks
"   and at the ends of lines
"   by changing text colors under Edit -> Settings)
"-------------------------------------------------

"------------ editor behavior block ------------------
set ruler                       " show curser position at all times
set sw=4						" Use 8 spaces when text is indented
"set tabstop=4                   " sets how many spaces a tab is
"set ai                          " auto indent
"set expandtab                   " tabs converted to spaces, uncomment when needed 
set incsearch                   " incremental search
set nohlsearch                  " no highlight on searching
set nowrap                      " no text wraps
set backspace=indent,eol,start  " allow backspacing over everything in insert mode
set term=ansi                   " 
set noerrorbells                " do not beep on errors
set ttyfast                     " Smoother scrolling
"set mouse=a                     " have mouse enabled at all time
set virtualedit=all             " allows curser to roam freely
set backspace=2                 " allows backspacing over everything
set showmode                    " show current mode you are in
set showcmd                     " display incomplete commands
set showmatch                   " show matching braces
set undolevels=500              " set the number of undo's
set novisualbell                " no sound on error
set title                       " Shows title in console window
set ls=2                        " always show status line
"set foldmethod=marker           " fold method using markers
set bg=dark
set nu
"-------------- Spell checking block ---------

"-------------- backup block ------------------

"------------ Graphical block -----------------
syntax on       " Turns on syntax highlighting
" available colorschemes include: morning, elflord, desert, murphay,
" pablo, koehler, shine, torte, zellner, darkblue, evening
" Try a new one by getting out of insert mode and typing
":colors colorSchemeName
" Make it always come up by editing the following line.
"colorscheme evening
"set nu          " Line numbers

" Key bindings
:colors evening
:autocmd FileType mail :nmap <F8> :w<CR>:!aspell -e -c %<CR>:e<CR>
