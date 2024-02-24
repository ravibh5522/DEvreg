#root finding using secant method
import sympy as sp
def secant(f,x0,x1,N):
    for i in range(0,N):
        x2 = x1 - f(x1)*(x1 - x0)/(f(x1) - f(x0))
        x0 = x1
        x1 = x2
    return x2
f = lambda x: x**2 - x - 1
x0 = 1
x1 = 2
N = 5
approx_phi = secant(f,x0,x1,N)
print(approx_phi)
